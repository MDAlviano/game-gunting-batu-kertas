package programmerzamannow.belajarandroiddasar

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var sayHelloButton: Button
    private lateinit var sayHelloTextView: TextView
    private lateinit var gameButton: Button

    private fun initComponents() {

        nameEditText = findViewById(R.id.nameEditText)
        sayHelloButton = findViewById(R.id.sayHelloButton)
        sayHelloTextView = findViewById(R.id.sayHelloTextView)
        gameButton = findViewById(R.id.gameButton)

    }

    private fun checkFingerprint() {
        if (packageManager.hasSystemFeature(PackageManager.FEATURE_FINGERPRINT)) {
            Log.i("FEATURE", "Feature Fingerprint On")
        } else {
            Log.w("FEATURE", "Feature Fingerprint Off")
        }
    }

    private fun checkPlatformVersion() {
        Log.i("SDK", Build.VERSION.SDK_INT.toString())
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S) {
            Log.i("SDK", "Disable feature, because version sdk is lower than 31")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.hello_world)

        initComponents()

        sayHelloTextView.text = resources.getString(R.string.app_name)

        sayHelloButton.setOnClickListener{

            checkFingerprint()
            checkPlatformVersion()

            val sample = resources.openRawResource(R.raw.sample)
                .bufferedReader()
                .use { it.readText() }
            Log.i("RAW", sample)

            val json = assets.open("sample.json")
                .bufferedReader()
                .use { it.readText() }
            Log.i("ASSET", json)

            Log.d("PZN", "this is debug log")
            Log.i("PZN", "this is info log")
            Log.w("PZN", "this is warn log")
            Log.e("PZN", "this is error log")

            Log.i("ValueResources", resources.getInteger(R.integer.maxPage).toString())
            Log.i("ValueResources", resources.getBoolean(R.bool.isProductionMode).toString())
            Log.i("ValueResources", resources.getIntArray(R.array.numbers).joinToString(","))
            Log.i("ValueResources", resources.getColor(R.color.background, theme).toString())

            sayHelloButton.setBackgroundColor(resources.getColor(R.color.background, theme))

            val name = nameEditText.text.toString()
            sayHelloTextView.text = resources.getString(R.string.sayHelloTextView, name)

            resources.getStringArray(R.array.names).forEach {
                Log.i("PZN", it)
            }
        }

        gameButton.setOnClickListener {
            val intent = Intent(this@MainActivity, GameActivity::class.java)
            startActivity(intent)
        }
    }
}