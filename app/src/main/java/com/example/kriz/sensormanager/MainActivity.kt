package com.example.kriz.sensormanager

import android.content.Context
import android.hardware.Sensor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.hardware.SensorManager
import android.widget.ImageView
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.media.Image
import android.view.View


class MainActivity : AppCompatActivity(),SensorEventListener {


    private var mSensorManager : SensorManager ?= null
    private var mAccelerometer : Sensor ?= null
    private var Right: ImageView? = null
    private var Left: ImageView? = null
    private var Default: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
        mSensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        mAccelerometer = mSensorManager!!.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        mSensorManager!!.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_FASTEST)
        Left = findViewById(R.id.imageView1)
        Right = findViewById(R.id.imageView2)
        Default = findViewById(R.id.imageView3)
    }

    override fun onSensorChanged(event: SensorEvent) {
        if(event.values[0]>5) {
            Left?.visibility= View.VISIBLE
            Right?.visibility= View.GONE
            Default?.visibility= View.GONE
        } else if (event.values[0]<-5){
            Left?.visibility= View.GONE
            Right?.visibility= View.VISIBLE
            Default?.visibility= View.GONE
        }

    }
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
