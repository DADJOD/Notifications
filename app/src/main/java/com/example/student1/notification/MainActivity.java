package com.example.student1.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.RemoteInput;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
// import android.support.v7.app.NotificationCompat;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.RemoteViews;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Самое простое уведомление:
    // Маленькая иконка для статус бара,
    // заголовок и содержание
    public void simpleNotification(View view) {

    }

    // Удаление уведомление - 
    // требуется идентификатор, с которым оно
    // было запущено
    public void simpleCancel(View view) {

    }


    // Запуск броузера через уведомление
    public void browserNotification(View view) {
        // Создание PendingIntent - "консерва" которую можно передать кому-то
        // чтобы кто-то другой (не наше приложение) выполнил этот интент

        // Что будет выполнено при щелчке на
        // уведомление

                // После выбора уведомления оно будет убрано
                // из статус-бара

    }

    // Сложное уведомление - содержит дополнительные кнопки
    // по щелчку на которые запустяться другие 
    // PendingIntent
    public void complexNotification(View view) {

        // PendingIntent для запуска броузера

        // PendingIntent для запуска карты

        // Акция - кнопка с иконкой, текстом и
        // PendingIntent

    }


    private int numberOfMessages = 12;

    // Новый вид уведомлений - "Большая картинка"
    // Будет полноэкранным (приоритет + звук)
    // Со стэком активностей
    public void bigPicture(View view) {


        // Вначале создадим стиль и определим его

        // Картинка из ресурсов

        // Есть еще виды стилей
        // MediaStyle - для проигрывания звука или видео
        // InboxStyle - 6 или 7 строк текста

        // Чтобы сделать уведомление полноэкранным
        // нужно установить высокий приоритет +
        // должна быть или вибрация или звук

    }

    // Собственный вид уведомления
    public void custom(View view) {

        // PendingIntent на запуск броузера
        PendingIntent pIntent = null;

        // Так как иерархия View не принадлежит
        // приложению, нужно использовать RemoteViews
        RemoteViews remote = new RemoteViews(
                getPackageName(),
                R.layout.custom
        );

        // Так устанавливаются значения виджетов внутри RemoteViews
        remote.setImageViewResource(R.id.picture, R.mipmap.ic_launcher);
        remote.setTextViewText(R.id.text, "Текст с картинкой");
        remote.setOnClickPendingIntent(R.id.button, pIntent);


    }


    // Inline reply уведомление -
    // можно ввести текст
    public void inlineReply(View view) {
        final String replyLabel = "Ответ";

        RemoteInput remoteInput = new RemoteInput.Builder(getResources().getString(R.string.KEY_TEXT_REPLY))
                .setLabel(replyLabel)
                .build();

        Intent intent = null;

        PendingIntent replyPendingIntent = null;

        NotificationCompat.Action replyAction = new NotificationCompat.Action.Builder(
                android.R.drawable.btn_plus,
                "Ответить",
                replyPendingIntent
        )
                .addRemoteInput(remoteInput)
                .build();

        Notification newMessageNotification = null;

        NotificationManagerCompat.from(this).notify(
                R.id.DIRECT_REPLY_NOTIFICATION_ID,
                newMessageNotification
        );

    }
}















