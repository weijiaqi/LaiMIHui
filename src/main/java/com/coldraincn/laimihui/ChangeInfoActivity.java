package com.coldraincn.laimihui;


        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.text.TextUtils;
        import android.util.Log;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.Toast;

        import com.coldraincn.laimihui.entity.BindPhone;
        import com.coldraincn.laimihui.presenter.ChangeInfoPresenter;
        import com.coldraincn.laimihui.view.ChangeInfoView;

public class ChangeInfoActivity extends AppCompatActivity implements View.OnClickListener {
    private ChangeInfoPresenter changeInfoPresenter = new ChangeInfoPresenter(this);
    private EditText et_name;
    private EditText ev_idCard;

    public static final String PREFUSER = "USER";
    public static final String PREF_CELL = "CELL";
    public static final String PREF_TOKEN = "TOKEN";
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_info);
        getSupportActionBar().hide();
        SharedPreferences settings = getSharedPreferences(PREFUSER, 0);
        token = settings.getString(PREF_TOKEN, "1");
        et_name = (EditText) findViewById(R.id.et_name);
        ev_idCard = (EditText) findViewById(R.id.ev_idCard);
        findViewById(R.id.ll_bind_number).setOnClickListener(this);
        findViewById(R.id.btn_save).setOnClickListener(this);
        changeInfoPresenter.onCreate();
        changeInfoPresenter.attachView(changeInfoView);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_bind_number:
                startActivity(new Intent(ChangeInfoActivity.this, ChangeMobileActivity.class));
                break;
            case R.id.btn_save:
                save();
                break;
        }
    }

    private void save() {
        String name = et_name.getText().toString().trim();
        String id = ev_idCard.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(ChangeInfoActivity.this, "姓名不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(id)) {
            Toast.makeText(ChangeInfoActivity.this, "身份证号不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        changeInfoPresenter.savePersonData(token, name, id);

    }

    private ChangeInfoView changeInfoView = new ChangeInfoView() {
        @Override
        public void onSuccess(BindPhone bindPhone) {
            Log.e("onSuccess", bindPhone.getData() + "," + bindPhone.getStatus());
            if ("OK".equals(bindPhone.getStatus())) {
                finish();
            }
            Toast.makeText(ChangeInfoActivity.this, bindPhone.getData(), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onError(String result) {
            Toast.makeText(ChangeInfoActivity.this, "绑定失败，请重试！", Toast.LENGTH_LONG).show();
        }
    };
}
