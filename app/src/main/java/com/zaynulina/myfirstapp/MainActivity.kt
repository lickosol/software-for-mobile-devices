package com.zaynulina.myfirstapp

//import kotlinx.android.synthetic.main.activity_main.*
import android.annotation.SuppressLint
import android.os.Bundle
import android.text.InputType
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class MainActivity: AppCompatActivity() {
     private var isEmailMode = true

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val button_num = findViewById<Button>(R.id.number)
        val button_em = findViewById<Button>(R.id.email)
        val editText_email = findViewById<EditText>(R.id.mail)
        val editText_pw = findViewById<EditText>(R.id.pw)
        val editText_agpw = findViewById<EditText>(R.id.again_pw)
        val regbutton = findViewById<Button>(R.id.regbutton)
        var button_num_pressed = false
        var button_em_pressed = false


         button_em.setOnClickListener {
             // Подсветка кнопки "По email"
             button_em.setBackgroundColor(
                 ContextCompat.getColor
                     (this, androidx.appcompat.R.color.material_blue_grey_800))
             button_num.setBackgroundColor(ContextCompat.getColor(this, R.color.white))

             editText_email.hint = "Введите email" // hint для email
             editText_email.inputType = InputType.TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS
             button_em_pressed = true
             button_num_pressed = false


         }
         button_num.setOnClickListener {
             // Подсветка кнопки "По номеру"
             button_num.setBackgroundColor(ContextCompat.getColor
                 (this, androidx.appcompat.R.color.material_blue_grey_900))
             button_em.setBackgroundColor(ContextCompat.getColor(this, R.color.white))

             editText_email.hint = "Введите телефон"
             editText_email.inputType = InputType.TYPE_CLASS_PHONE
             button_em_pressed = false
             button_num_pressed = true
         }

        regbutton.setOnClickListener {
            val pw = editText_pw.text.toString()
            val pwagn = editText_agpw.text.toString()
            val mail = editText_email.text.toString()
            if(pw != pwagn){
                Toast.makeText(this@MainActivity, "Пароли не совпадают", Toast.LENGTH_SHORT).show();
            }
            if(pw.isBlank() or pwagn.isBlank() or mail.isBlank()){
                Toast.makeText(this@MainActivity, "Заполните все необходимые поля", Toast.LENGTH_SHORT).show();
            }
            if(pw.length < 8){
                Toast.makeText(this@MainActivity, "Пароль должен содержать как минимум 8 символов", Toast.LENGTH_SHORT).show();
            }

            if(button_num_pressed){ //если мы во вкладке по номеру
                if(!mail.contains("+")){
                    Toast.makeText(this@MainActivity, "Некорректный номер телефона", Toast.LENGTH_LONG).show();
                }
            }
            if(button_em_pressed){
                if(!mail.contains("@")){
                    Toast.makeText(this@MainActivity, "Некорректный почтовый адрес", Toast.LENGTH_LONG).show();
                }
            }

        }

     }




 }