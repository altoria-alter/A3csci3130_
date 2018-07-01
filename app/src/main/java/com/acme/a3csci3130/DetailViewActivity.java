package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class DetailViewActivity extends Activity {

    private EditText businessNumField, nameField, addressField, emailField;
    private Spinner primaryBusinessSpin, provinceSpin;

    private Contact receivedPersonInfo;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");

        appState = ((MyApplicationData) getApplicationContext());

        //Initially define the values for editing contact
        businessNumField = (EditText) findViewById(R.id.businessNo_detail);
        emailField = (EditText)findViewById(R.id.email_detail);
        nameField = (EditText) findViewById(R.id.name_detail);
        addressField = (EditText) findViewById(R.id.address_detail);

        primaryBusinessSpin = (Spinner) findViewById(R.id.primaryBusiness_detail);
        provinceSpin = (Spinner) findViewById(R.id.province_detail);

        //using ArrayAdapter to setting the two spinners
        ArrayAdapter<CharSequence> adapterPrimary = ArrayAdapter.createFromResource(this,
                R.array.primaryBusiness_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterProvince = ArrayAdapter.createFromResource(this,
                R.array.province_array, android.R.layout.simple_spinner_item);
        adapterPrimary.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterProvince.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        primaryBusinessSpin.setAdapter(adapterPrimary);
        provinceSpin.setAdapter(adapterProvince);

        //null case handle
        if(receivedPersonInfo != null){
            emailField.setText(receivedPersonInfo.email);
            businessNumField.setText(String.valueOf(receivedPersonInfo.businessNO));
            nameField.setText(receivedPersonInfo.name);
            addressField.setText(receivedPersonInfo.address);

            primaryBusinessSpin.setSelection(getIndex(primaryBusinessSpin, receivedPersonInfo.primaryBusiness));
            provinceSpin.setSelection(getIndex(provinceSpin, receivedPersonInfo.province));
        }
    }

    //getIndex method for locating which option is selected for the spinner
   private int getIndex(Spinner spinner, String myString)
    {
        int index = 0;
        for (int i=0;i<spinner.getCount();i++){
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(myString)){
                index = i;
                break;
            }
        }
        return index;
    }

    //update method for editing the contact in the firebase
    public void update(View v){
        String personID = receivedPersonInfo.uid;
        try{
            int businessNO = Integer.parseInt(businessNumField.getText().toString());
            
            String name = nameField.getText().toString();
            String email = emailField.getText().toString();
            String address = addressField.getText().toString();

            String primaryBusiness = primaryBusinessSpin.getSelectedItem().toString();
            String province = provinceSpin.getSelectedItem().toString();

            Contact person = new Contact(personID, name, email, address, province, primaryBusiness, businessNO);

            appState.firebaseReference.child(personID).setValue(person);
        }
        catch(NumberFormatException e){
        }

        finish();
    }

    //erase method for deleting the contact in the firebase
    public void erase(View v)
    {
        String personID = receivedPersonInfo.uid;
        appState.firebaseReference.child(personID).removeValue();

        finish();
    }
}