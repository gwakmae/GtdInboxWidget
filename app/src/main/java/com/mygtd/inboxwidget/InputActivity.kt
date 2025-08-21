package com.mygtd.inboxwidget

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class InputActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        window.setLayout(
            (resources.displayMetrics.widthPixels * 0.9).toInt(), // 가로 폭을 화면의 90%로 설정
            android.view.ViewGroup.LayoutParams.WRAP_CONTENT // 세로 높이는 내용물에 맞게 자동 조절
        )

        // XML에 있는 EditText와 Button을 코드에서 사용할 수 있도록 연결합니다.
        val editText = findViewById<EditText>(R.id.input_edit_text)
        val addButton = findViewById<Button>(R.id.input_add_button)

        // '추가' 버튼에 클릭 리스너를 설정합니다.
        addButton.setOnClickListener {
            val inputText = editText.text.toString()

            if (inputText.isNotBlank()) {
                // 나중에 이 부분에 서버로 데이터를 전송하는 코드가 들어갑니다.
                // 지금은 '가짜' 동작으로 팝업 메시지만 띄웁니다.
                Toast.makeText(this, "'$inputText' 가 추가되었습니다! (가짜 동작)", Toast.LENGTH_SHORT).show()

                // 입력이 완료되었으므로 화면을 닫습니다.
                finish()
            } else {
                Toast.makeText(this, "내용을 입력해주세요.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}