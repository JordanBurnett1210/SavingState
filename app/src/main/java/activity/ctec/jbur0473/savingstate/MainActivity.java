package activity.ctec.jbur0473.savingstate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import tec.savingstate.model.AndroidSaveState;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.CheckBox;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity
{
    private Button submitButton;
    private EditText nameText;
    private EditText ageText;
    private CheckBox isTiredBox;

    private Application saveState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveState = (AndroidSaveState) getApplication();

        submitButton = (Button) findViewById(R.id.backButton);
        nameText = (EditText) findViewById(R.id.nameText);
        ageText= (EditText) findViewById(R.id.ageText);
        isTiredBox = (CheckBox) findViewById(R.id.isTiredBox);

        setupListeners();
    }

    private void setupListeners()
    {
        submitButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View clickView)
            {
                String name = nameText.getText().toString();
                int age = Integer.parseInt(ageText.getText().toString());
                boolean isTired = isTiredBox.isChecked();

                Intent newScreenIntent = new Intent(clickView.getContext(), BackPageActivity.class);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
