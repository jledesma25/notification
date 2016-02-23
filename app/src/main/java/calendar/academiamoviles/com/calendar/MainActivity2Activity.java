package calendar.academiamoviles.com.calendar;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.RemoteViews;

public class MainActivity2Activity extends ActionBarActivity {

    private final int NOTIFICATION_ID = 1010;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);
        triggerNotification();

    }


    private void triggerNotification(){

        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Notification notification = new Notification(R.drawable.descarga, "¡Nuevo mensaje!", System.currentTimeMillis());

        RemoteViews contentView = new RemoteViews(getPackageName(), R.layout.notification_layout);
        contentView.setImageViewResource(R.id.img_notification, R.drawable.descarga);
        contentView.setTextViewText(R.id.txt_notification, "Notificacion Personalizada, aca va el texto que deseas enviar al usuario");

        notification.contentView = contentView;

        Intent notificationIntent = new Intent(this, MainActivity2Activity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
        notification.contentIntent = contentIntent;

        notificationManager.notify(NOTIFICATION_ID, notification);
    }

}
