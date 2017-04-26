package com.example.administrador.bannerfacebook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.widget.ProfilePictureView;

public class MainActivity extends AppCompatActivity {

    TextView txtUser;
    ProfilePictureView imagenUsuario;
    Button btnCerrarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUser = (TextView) findViewById(R.id.tvUsuario);
        imagenUsuario = (ProfilePictureView) findViewById(R.id.imgProfile);
        btnCerrarSesion = (Button) findViewById(R.id.btonCerrarSesion);

        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginManager.getInstance().logOut();
                IrPantallaLogin();
            }
        });

        if (AccessToken.getCurrentAccessToken()==null){
            IrPantallaLogin();
        }else {
            Profile profile = Profile.getCurrentProfile();
            txtUser.setText(profile.getName());
            imagenUsuario.setProfileId(profile.getId());
        }

    }

    private void IrPantallaLogin() {
        Intent intent = new Intent(MainActivity.this,LoginActivity.class);
        finish();
        startActivity(intent);
    }
}
