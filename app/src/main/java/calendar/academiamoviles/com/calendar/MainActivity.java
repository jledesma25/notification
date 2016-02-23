package calendar.academiamoviles.com.calendar;

import android.app.Activity;
import android.content.Intent;
import android.provider.CalendarContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import java.util.Calendar;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{


    Button btnOn;
    Button btnOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);


        btnOn = (Button) findViewById(R.id.buttonOn);
        btnOff = (Button) findViewById(R.id.buttonOff);

        btnOn.setOnClickListener(this);
        btnOff.setOnClickListener(this);

        //Primer comment
    }



    private void addEventToCalendar(Activity activity){
        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.DAY_OF_MONTH, 16);
        cal.set(Calendar.MONTH, 1);
        cal.set(Calendar.YEAR, 2016);

        cal.set(Calendar.HOUR_OF_DAY, 13);
        cal.set(Calendar.MINUTE, 02);

        Intent intent = new Intent(Intent.ACTION_EDIT);
        intent.setType("vnd.android.cursor.item/event");

        intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, cal.getTimeInMillis());
        intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, cal.getTimeInMillis()+60*60*1000);

        intent.putExtra(CalendarContract.Events.ALL_DAY, false);
        intent.putExtra(CalendarContract.Events.RRULE , "FREQ=DAILY");
        intent.putExtra(CalendarContract.Events.TITLE, "Evento");
        intent.putExtra(CalendarContract.Events.DESCRIPTION, "Descripcion");
        intent.putExtra(CalendarContract.Events.EVENT_LOCATION,"Calle ....");

        activity.startActivity(intent);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.buttonOn:
                startService(new Intent(MainActivity.this, MyService.class));
                break;
            case R.id.buttonOff:
                stopService(new Intent(MainActivity.this, MyService.class));
                break;

        }

    }
}
