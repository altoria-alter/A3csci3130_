package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class CreateContactAcitivity extends Activity {

    private Button submitButton;
    private EditText nameField, emailField, businessNOField, addressField;
    private MyApplicationData appState;
    private Spinner primaryBusinessSpinner, provinceSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact_acitivity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());

        //Define value for the contact object
        submitButton = (Button) findViewById(R.id.submitButton);

        nameField = (EditText) findViewById(R.id.name);
        emailField = (EditText) findViewById(R.id.email);
        businessNOField = (EditText) findViewById(R.id.businessNO);
        addressField = (EditText) findViewById(R.id.address);

        primaryBusinessSpinner = (Spinner) findViewById(R.id.primaryBusiness);
        provinceSpinner = (Spinner) findViewById(R.id.province);

        //Using ArrayAdapter to display the spinner
        ArrayAdapter<CharSequence> adapterPrimary = ArrayAdapter.createFromResource(this,
                R.array.primaryBusiness_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterProvince = ArrayAdapter.createFromResource(this,
                R.array.province_array, android.R.layout.simple_spinner_item);
        adapterPrimary.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterProvince.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        primaryBusinessSpinner.setAdapter(adapterPrimary);
        provinceSpinner.setAdapter(adapterProvince);
    }

    public void submitInfoButton(View v) {
        //each entry needs a unique ID
        String personID = appState.firebaseReference.push().getKey();
        try {
            String name = nameField.getText().toString();
            String email = emailField.getText().toString();
            String address = addressField.getText().toString();

            String primaryBusiness = primaryBusinessSpinner.getSelectedItem().toString();
            String province = provinceSpinner.getSelectedItem().toString();

            int businessNo = Integer.parseInt(businessNOField.getText().toString());

            Contact person = new Contact(personID, name, email, address, province, primaryBusiness, businessNo);

            appState.firebaseReference.child(personID).setValue(person);
        }
        catch (NumberFormatException e){
        }
        finish();
    }
}
