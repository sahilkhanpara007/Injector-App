package com.plexus.lieshooter;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.Typeface;
import android.os.Build;
import android.os.IBinder;
import android.widget.Toast;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.SeekBar.OnSeekBarChangeListener;

import static java.lang.System.exit;
import android.widget.Switch;
import android.widget.Button;
import com.plexus.lieshooter.SketchwareUtil;
import com.plexus.lieshooter.ESPPAPA;
public class FloatLogo extends Service implements View.OnClickListener {

    private WindowManager mWindowManager;
    private View mFloatingView;
    View espView,logoView;
	
	
	static boolean floatAimbot=false;
    private static FloatLogo Instance;

    public native String TITLE();

    static {
        System.loadLibrary("native-lib");
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        Instance=this;
        createOver();
        logoView = mFloatingView.findViewById(R.id.relativeLayoutParent);
        espView = mFloatingView.findViewById(R.id.espView);
        TextView textView4 = mFloatingView.findViewById(R.id.textView4);
        textView4.setText(TITLE());
        textView4.setTypeface(Typeface.createFromAsset(getAssets(), "font/zt2.ttf"));

        Init();
    }

    void createOver(){
        //getting the widget layout from xml using layout inflater
        mFloatingView = LayoutInflater.from(this).inflate(R.layout.float_logo, null);
        int LAYOUT_FLAG;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LAYOUT_FLAG = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        } else {
            LAYOUT_FLAG = WindowManager.LayoutParams.TYPE_PHONE;
        }
		
        //setting the layout parameters
        final WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                LAYOUT_FLAG,
				
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.RGBA_8888);


        //getting windows services and adding the floating view to it
        mWindowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        mWindowManager.addView(mFloatingView, params);
		ESPPAPA.setFakeRecorderWindowLayoutParams(params);
		

        final GestureDetector gestureDetector = new GestureDetector(this, new SingleTapConfirm());
        //window funclion
        ImageView closeBtn=mFloatingView.findViewById(R.id.closeBtn);
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                espView.setVisibility(View.GONE);
                logoView.setVisibility(View.VISIBLE);
            }
        });
		
	
        final LinearLayout Player =mFloatingView.findViewById(R.id.Player);
        final LinearLayout Item =mFloatingView.findViewById(R.id.Item);
        final LinearLayout Vehicle =mFloatingView.findViewById(R.id.Vehicle);
		final LinearLayout Aimbot =mFloatingView.findViewById(R.id.Aimbot);
		final LinearLayout Sdk =mFloatingView.findViewById(R.id.Sdk);
		final LinearLayout Setting =mFloatingView.findViewById(R.id.Setting);
		
		
		final Button menu_1 = mFloatingView.findViewById(R.id.menu_1);
		final Button menu_2 = mFloatingView.findViewById(R.id.menu_2);
		final Button menu_3 = mFloatingView.findViewById(R.id.menu_3);
		final Button menu_4 = mFloatingView.findViewById(R.id.menu_4);
		final Button menu_5 = mFloatingView.findViewById(R.id.menu_5);
		final Button menu_6 = mFloatingView.findViewById(R.id.menu_6);
		
		
		final LinearLayout bg_menu_1 = mFloatingView.findViewById(R.id.bg_menu_1);
        final LinearLayout bg_menu_2 = mFloatingView.findViewById(R.id.bg_menu_2);
        final LinearLayout bg_menu_3 = mFloatingView.findViewById(R.id.bg_menu_3);
		final LinearLayout bg_menu_4 = mFloatingView.findViewById(R.id.bg_menu_4);
		final LinearLayout bg_menu_5 = mFloatingView.findViewById(R.id.bg_menu_5);
		final LinearLayout bg_menu_6 = mFloatingView.findViewById(R.id.bg_menu_6);
		
        menu_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
				
				menu_1.setBackgroundResource(R.drawable.radius6);
				menu_2.setBackgroundResource(R.drawable.shoot);
				menu_3.setBackgroundResource(R.drawable.shoot);
				menu_4.setBackgroundResource(R.drawable.shoot);
				menu_5.setBackgroundResource(R.drawable.shoot);
				menu_6.setBackgroundResource(R.drawable.shoot);
				
				;
				
				
                Player.setVisibility(View.VISIBLE);
                Item.setVisibility(View.GONE);
                Vehicle.setVisibility(View.GONE);
				Aimbot.setVisibility(View.GONE);
				Sdk.setVisibility(View.GONE);
				Setting.setVisibility(View.GONE);
                
            }
			
        });

        menu_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu_1.setBackgroundResource(R.drawable.shoot);
				menu_2.setBackgroundResource(R.drawable.radius6);
				menu_3.setBackgroundResource(R.drawable.shoot);
				menu_4.setBackgroundResource(R.drawable.shoot);
				menu_5.setBackgroundResource(R.drawable.shoot);
				menu_6.setBackgroundResource(R.drawable.shoot);
				
                Player.setVisibility(View.GONE);
                Item.setVisibility(View.VISIBLE);
                Vehicle.setVisibility(View.GONE);
				Aimbot.setVisibility(View.GONE);
				Sdk.setVisibility(View.GONE);
				Setting.setVisibility(View.GONE);
                
            }
        });
		
		

        menu_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	menu_1.setBackgroundResource(R.drawable.shoot);
				menu_2.setBackgroundResource(R.drawable.shoot);
				menu_3.setBackgroundResource(R.drawable.radius6);
				menu_4.setBackgroundResource(R.drawable.shoot);
				menu_5.setBackgroundResource(R.drawable.shoot);
				menu_6.setBackgroundResource(R.drawable.shoot);
				
                Player.setVisibility(View.GONE);
                Item.setVisibility(View.GONE);
                Vehicle.setVisibility(View.VISIBLE);
				Aimbot.setVisibility(View.GONE);
				Sdk.setVisibility(View.GONE);
				Setting.setVisibility(View.GONE);
                
            }
        });
        menu_4.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					menu_1.setBackgroundResource(R.drawable.shoot);
					menu_2.setBackgroundResource(R.drawable.shoot);
					menu_3.setBackgroundResource(R.drawable.shoot);
					menu_4.setBackgroundResource(R.drawable.radius6);
					menu_5.setBackgroundResource(R.drawable.shoot);
					menu_6.setBackgroundResource(R.drawable.shoot);
					
					Player.setVisibility(View.GONE);
					Item.setVisibility(View.GONE);
					Vehicle.setVisibility(View.GONE);
					Aimbot.setVisibility(View.VISIBLE);
					Sdk.setVisibility(View.GONE);
					Setting.setVisibility(View.GONE);
					
				}
			});
        
		menu_5.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					menu_1.setBackgroundResource(R.drawable.shoot);
					menu_2.setBackgroundResource(R.drawable.shoot);
					menu_3.setBackgroundResource(R.drawable.shoot);
					menu_4.setBackgroundResource(R.drawable.shoot);
					menu_5.setBackgroundResource(R.drawable.radius6);
					menu_6.setBackgroundResource(R.drawable.shoot);
					
					Player.setVisibility(View.GONE);
					Item.setVisibility(View.GONE);
					Vehicle.setVisibility(View.GONE);
					Aimbot.setVisibility(View.GONE);
					Sdk.setVisibility(View.VISIBLE);
					Setting.setVisibility(View.GONE);
					
				}
			});
			
		menu_6.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					menu_1.setBackgroundResource(R.drawable.shoot);
					menu_2.setBackgroundResource(R.drawable.shoot);
					menu_3.setBackgroundResource(R.drawable.shoot);
					menu_4.setBackgroundResource(R.drawable.shoot);
					menu_5.setBackgroundResource(R.drawable.shoot);
					menu_6.setBackgroundResource(R.drawable.radius6);
					
					Player.setVisibility(View.GONE);
					Item.setVisibility(View.GONE);
					Vehicle.setVisibility(View.GONE);
					Aimbot.setVisibility(View.GONE);
					Sdk.setVisibility(View.GONE);
					Setting.setVisibility(View.VISIBLE);
					
				}
			});

        //floating window setting
        mFloatingView.findViewById(R.id.relativeLayoutParent).setOnTouchListener(new View.OnTouchListener() {
            private int initialX;
            private int initialY;
            private float initialTouchX;
            private float initialTouchY;

            public boolean onTouch(View v, MotionEvent event) {
                if (gestureDetector.onTouchEvent(event)) {
                    espView.setVisibility(View.VISIBLE);
                    logoView.setVisibility(View.GONE);
                    return true;
                } else {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            initialX = params.x;
                            initialY = params.y;
                            initialTouchX = event.getRawX();
                            initialTouchY = event.getRawY();
                            return true;
                        case MotionEvent.ACTION_MOVE:
                            //this code is helping the widget to move around the screen with fingers
                            params.x = initialX + (int) (event.getRawX() - initialTouchX);
                            params.y = initialY + (int) (event.getRawY() - initialTouchY);
                            mWindowManager.updateViewLayout(mFloatingView, params);
                            return true;
                    }
                    return false;
                }
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
        if (mFloatingView != null) mWindowManager.removeView(mFloatingView);
    }

    public void onClick(View v) {

    }

    private String getType(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getString("type","1");
    }

    private void  setValue(String key,boolean b) {
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putBoolean(key,b);
        ed.apply();
    }

    boolean getConfig(String key){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return  sp.getBoolean(key,false);
        // return !key.equals("");
    }

    void setFps(int fps){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("fps",fps);
        ed.apply();
    }

    void setPosition(int position){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("position",position);
        ed.apply();
    }

    void setSize(int size){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("size",size);
        ed.apply();
    }

    void setItemSIze(int ItemSize){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("ItemSize",ItemSize);
        ed.apply();
    }

    void setItemPosition(int ItemPosition){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("ItemPosition",ItemPosition);
        ed.apply();
    }

    int getItemSize(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("ItemSize",0);
    }

    int getItemPosition(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("ItemPosition",0);
    }

    int getFps(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("fps",100);
    }

    int getPosition(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("position",0);
    }

    int getSize(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("size",0);
    }

    public static void HideFloat() {
        if (Instance != null)
        {
            Instance.Hide();
        }
    }
    public void Hide(){
        stopSelf();
        exit(-1);
    }

    void Init(){
        final CheckBox Buggy = mFloatingView.findViewById(R.id.Buggy);
        Buggy.setChecked(getConfig((String) Buggy.getText()));
        Buggy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Buggy.getText()), Buggy.isChecked());
            }
        });
        final CheckBox UAZ = mFloatingView.findViewById(R.id.UAZ);
        UAZ.setChecked(getConfig((String) UAZ.getText()));
        UAZ.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(UAZ.getText()), UAZ.isChecked());
            }
        });
        final CheckBox Trike = mFloatingView.findViewById(R.id.Trike);
        Trike.setChecked(getConfig((String) Trike.getText()));
        Trike.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Trike.getText()), Trike.isChecked());
            }
        });
        final CheckBox Bike = mFloatingView.findViewById(R.id.Bike);
        Bike.setChecked(getConfig((String) Bike.getText()));
        Bike.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Bike.getText()), Bike.isChecked());
            }
        });
        final CheckBox Dacia = mFloatingView.findViewById(R.id.Dacia);
        Dacia.setChecked(getConfig((String) Dacia.getText()));
        Dacia.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Dacia.getText()), Dacia.isChecked());
            }
        });
        final CheckBox Jet = mFloatingView.findViewById(R.id.Jet);
        Jet.setChecked(getConfig((String) Jet.getText()));
        Jet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Jet.getText()), Jet.isChecked());
            }
        });
        final CheckBox Boat = mFloatingView.findViewById(R.id.Boat);
        Boat.setChecked(getConfig((String) Boat.getText()));
        Boat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Boat.getText()), Boat.isChecked());
            }
        });
        final CheckBox Scooter = mFloatingView.findViewById(R.id.Scooter);
        Scooter.setChecked(getConfig((String) Scooter.getText()));
        Scooter.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Scooter.getText()), Scooter.isChecked());
            }
        });
        final CheckBox Bus = mFloatingView.findViewById(R.id.Bus);
        Bus.setChecked(getConfig((String) Bus.getText()));
        Bus.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Bus.getText()), Bus.isChecked());
            }
        });
        final CheckBox Mirado = mFloatingView.findViewById(R.id.Mirado);
        Mirado.setChecked(getConfig((String) Mirado.getText()));
        Mirado.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Mirado.getText()), Mirado.isChecked());
            }
        });
        final CheckBox Rony = mFloatingView.findViewById(R.id.Rony);
        Rony.setChecked(getConfig((String) Rony.getText()));
        Rony.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Rony.getText()), Rony.isChecked());
            }
        });
        final CheckBox Snowbike = mFloatingView.findViewById(R.id.Snowbike);
        Snowbike.setChecked(getConfig((String) Snowbike.getText()));
        Snowbike.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Snowbike.getText()), Snowbike.isChecked());
            }
        });
        final CheckBox Snowmobile = mFloatingView.findViewById(R.id.Snowmobile);
        Snowmobile.setChecked(getConfig((String) Snowmobile.getText()));
        Snowmobile.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Snowmobile.getText()), Snowmobile.isChecked());
            }
        });
        final CheckBox Tempo = mFloatingView.findViewById(R.id.Tempo);
        Tempo.setChecked(getConfig((String) Tempo.getText()));
        Tempo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Tempo.getText()), Tempo.isChecked());
            }
        });
        final CheckBox Truck = mFloatingView.findViewById(R.id.Truck);
        Truck.setChecked(getConfig((String) Truck.getText()));
        Truck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Truck.getText()), Truck.isChecked());
            }
        });
        final CheckBox MonsterTruck = mFloatingView.findViewById(R.id.MonsterTruck);
        MonsterTruck.setChecked(getConfig((String) MonsterTruck.getText()));
        MonsterTruck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(MonsterTruck.getText()), MonsterTruck.isChecked());
            }
        });
        final CheckBox BRDM = mFloatingView.findViewById(R.id.BRDM);
        BRDM.setChecked(getConfig((String) BRDM.getText()));
        BRDM.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(BRDM.getText()), BRDM.isChecked());
            }
        });
        final CheckBox LadaNiva = mFloatingView.findViewById(R.id.LadaNiva);
        LadaNiva.setChecked(getConfig((String) LadaNiva.getText()));
        LadaNiva.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(LadaNiva.getText()), LadaNiva.isChecked());
            }
        });
        final CheckBox CheekPad = mFloatingView.findViewById(R.id.CheekPad);
        CheekPad.setChecked(getConfig((String) CheekPad.getText()));
        CheekPad.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(CheekPad.getText()), CheekPad.isChecked());
            }
        });
        final CheckBox AirDrop = mFloatingView.findViewById(R.id.AirDrop);
        AirDrop.setChecked(getConfig((String) AirDrop.getText()));
        AirDrop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(AirDrop.getText()), AirDrop.isChecked());
            }
        });
        final CheckBox Crate = mFloatingView.findViewById(R.id.Crate);
        Crate.setChecked(getConfig((String) Crate.getText()));
        Crate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Crate.getText()), Crate.isChecked());
            }
        });
        final CheckBox DropPlane = mFloatingView.findViewById(R.id.DropPlane);
        DropPlane.setChecked(getConfig((String) DropPlane.getText()));
        DropPlane.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(DropPlane.getText()), DropPlane.isChecked());
            }
        });
        final Switch isEnemyWeapon = mFloatingView.findViewById(R.id.isEnemyWeapon);
        isEnemyWeapon.setChecked(getConfig((String) isEnemyWeapon.getText()));
        SettingValue(10,getConfig((String) isEnemyWeapon.getText()));
        isEnemyWeapon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(isEnemyWeapon.getText()), isEnemyWeapon.isChecked());
                SettingValue(10,isEnemyWeapon.isChecked());
            }
        });
        final Switch isGrenadeWarning = mFloatingView.findViewById(R.id.isGrenadeWarning);
        isGrenadeWarning.setChecked(getConfig((String) isGrenadeWarning.getText()));
        SettingValue(9,getConfig((String) isGrenadeWarning.getText()));
        isGrenadeWarning.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(isGrenadeWarning.getText()), isGrenadeWarning.isChecked());
                SettingValue(9,isGrenadeWarning.isChecked());
            }
        });
        final Switch isSkelton = mFloatingView.findViewById(R.id.isSkelton);
        isSkelton.setChecked(getConfig((String) isSkelton.getText()));
        SettingValue(8,getConfig((String) isSkelton.getText()));
        isSkelton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(isSkelton.getText()), isSkelton.isChecked());
                SettingValue(8,isSkelton.isChecked());
            }
        });
        final Switch isHead = mFloatingView.findViewById(R.id.isHead);
        isHead.setChecked(getConfig((String) isHead.getText()));
        SettingValue(6,getConfig((String) isHead.getText()));
        isHead.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(isHead.getText()), isHead.isChecked());
                SettingValue(6,isHead.isChecked());
            }
        });
        final RadioButton isBox = mFloatingView.findViewById(R.id.isBox);
        isBox.setChecked(getConfig((String) isBox.getText()));
        SettingValue(1,getConfig((String) isBox.getText()));
        isBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(isBox.getText()), isBox.isChecked());
                SettingValue(1,isBox.isChecked());
            }
        });
		final RadioButton isBoxFill = mFloatingView.findViewById(R.id.isBoxFill);
        isBoxFill.setChecked(getConfig((String) isBoxFill.getText()));
        SettingValue(14,getConfig((String) isBoxFill.getText()));
        isBoxFill.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					setValue(String.valueOf(isBoxFill.getText()), isBoxFill.isChecked());
					SettingValue(14,isBoxFill.isChecked());
				}
			});
        final RadioButton isLineTop = mFloatingView.findViewById(R.id.isLineTop);
        isLineTop.setChecked(getConfig((String) isLineTop.getText()));
        SettingValue(2,getConfig((String) isLineTop.getText()));
        isLineTop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					setValue(String.valueOf(isLineTop.getText()), isLineTop.isChecked());
					SettingValue(2,isLineTop.isChecked());
				}
			});
		final RadioButton isLineMiddle = mFloatingView.findViewById(R.id.isLineMiddle);
        isLineMiddle.setChecked(getConfig((String) isLineMiddle.getText()));
        SettingValue(15,getConfig((String) isLineMiddle.getText()));
        isLineMiddle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					setValue(String.valueOf(isLineMiddle.getText()), isLineMiddle.isChecked());
					SettingValue(15,isLineMiddle.isChecked());
				}
			});
		final RadioButton isLineBottom = mFloatingView.findViewById(R.id.isLineBottom);
        isLineBottom.setChecked(getConfig((String) isLineBottom.getText()));
        SettingValue(16,getConfig((String) isLineBottom.getText()));
        isLineBottom.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					setValue(String.valueOf(isLineBottom.getText()), isLineBottom.isChecked());
					SettingValue(16,isLineBottom.isChecked());
				}
			});
        final Switch isBack = mFloatingView.findViewById(R.id.isBack);
        isBack.setChecked(getConfig((String) isBack.getText()));
        SettingValue(7,getConfig((String) isBack.getText()));
        isBack.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(isBack.getText()), isBack.isChecked());
                SettingValue(7,isBack.isChecked());
            }
        });
        final Switch isHealth = mFloatingView.findViewById(R.id.isHealth);
        isHealth.setChecked(getConfig((String) isHealth.getText()));
        SettingValue(4,getConfig((String) isHealth.getText()));
        isHealth.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(isHealth.getText()), isHealth.isChecked());
                SettingValue(4,isHealth.isChecked());
            }
        });
        final Switch isName = mFloatingView.findViewById(R.id.isName);
        isName.setChecked(getConfig((String) isName.getText()));
        SettingValue(5,getConfig((String) isName.getText()));
        isName.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(isName.getText()), isName.isChecked());
                SettingValue(5,isName.isChecked());
            }
        });
        
        
        
        
        final Switch isDist = mFloatingView.findViewById(R.id.isDist);
        isDist.setChecked(getConfig((String) isDist.getText()));
        SettingValue(3,getConfig((String) isDist.getText()));
        isDist.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(isDist.getText()), isDist.isChecked());
                SettingValue(3,isDist.isChecked());
            }
        });
        
        
        
        


        final CheckBox canted = mFloatingView.findViewById(R.id.canted);
        canted.setChecked(getConfig((String) canted.getText()));
        canted.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(canted.getText()),canted.isChecked());
            }
        });

        final CheckBox reddot = mFloatingView.findViewById(R.id.reddot);
        reddot.setChecked(getConfig((String) reddot.getText()));
        reddot.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(reddot.getText()),reddot.isChecked());
            }
        });

        final CheckBox hollow = mFloatingView.findViewById(R.id.hollow);
        hollow.setChecked(getConfig((String) hollow.getText()));
        hollow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(hollow.getText()),hollow.isChecked());
            }
        });

        final CheckBox twox = mFloatingView.findViewById(R.id.twox);
        twox.setChecked(getConfig((String) twox.getText()));
        twox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(twox.getText()),twox.isChecked());
            }
        });

        final CheckBox threex = mFloatingView.findViewById(R.id.threex);
        threex.setChecked(getConfig((String) threex.getText()));
        threex.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(threex.getText()),threex.isChecked());
            }
        });

        final CheckBox fourx = mFloatingView.findViewById(R.id.fourx);
        fourx.setChecked(getConfig((String) fourx.getText()));
        fourx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(fourx.getText()),fourx.isChecked());
            }
        });

        final CheckBox sixx = mFloatingView.findViewById(R.id.sixx);
        sixx.setChecked(getConfig((String) sixx.getText()));
        sixx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(sixx.getText()),sixx.isChecked());
            }
        });

        final CheckBox eightx = mFloatingView.findViewById(R.id.eightx);
        eightx.setChecked(getConfig((String) eightx.getText()));
        eightx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(eightx.getText()),eightx.isChecked());
            }
        });

        final CheckBox AWM = mFloatingView.findViewById(R.id.AWM);
        AWM.setChecked(getConfig((String) AWM.getText()));
        AWM.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(AWM.getText()),AWM.isChecked());
            }
        });

        final CheckBox QBU = mFloatingView.findViewById(R.id.QBU);
        QBU.setChecked(getConfig((String) QBU.getText()));
        QBU.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(QBU.getText()),QBU.isChecked());
            }
        });

        final CheckBox SLR = mFloatingView.findViewById(R.id.SLR);
        SLR.setChecked(getConfig((String) SLR.getText()));
        SLR.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(SLR.getText()),SLR.isChecked());
            }
        });

        final CheckBox SKS = mFloatingView.findViewById(R.id.SKS);
        SKS.setChecked(getConfig((String) SKS.getText()));
        SKS.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(SKS.getText()),SKS.isChecked());
            }
        });

        final CheckBox Mini14 = mFloatingView.findViewById(R.id.Mini14);
        Mini14.setChecked(getConfig((String) Mini14.getText()));
        Mini14.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Mini14.getText()),Mini14.isChecked());
            }
        });

        final CheckBox M24 = mFloatingView.findViewById(R.id.M24);
        M24.setChecked(getConfig((String) M24.getText()));
        M24.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(M24.getText()),M24.isChecked());
            }
        });

        final CheckBox Kar98k = mFloatingView.findViewById(R.id.Kar98k);
        Kar98k.setChecked(getConfig((String) Kar98k.getText()));
        Kar98k.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Kar98k.getText()),Kar98k.isChecked());
            }
        });

        final CheckBox VSS = mFloatingView.findViewById(R.id.VSS);
        VSS.setChecked(getConfig((String) VSS.getText()));
        VSS.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(VSS.getText()),VSS.isChecked());
            }
        });

        final CheckBox Win94 = mFloatingView.findViewById(R.id.Win94);
        Win94.setChecked(getConfig((String) Win94.getText()));
        Win94.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Win94.getText()),Win94.isChecked());
            }
        });

        final CheckBox AUG = mFloatingView.findViewById(R.id.AUG);
        AUG.setChecked(getConfig((String) AUG.getText()));
        AUG.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(AUG.getText()),AUG.isChecked());
            }
        });

        final CheckBox M762 = mFloatingView.findViewById(R.id.M762);
        M762.setChecked(getConfig((String) M762.getText()));
        M762.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(M762.getText()),M762.isChecked());
            }
        });

        final CheckBox SCARL = mFloatingView.findViewById(R.id.SCARL);
        SCARL.setChecked(getConfig((String) SCARL.getText()));
        SCARL.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(SCARL.getText()),SCARL.isChecked());
            }
        });

        final CheckBox M416 = mFloatingView.findViewById(R.id.M416);
        M416.setChecked(getConfig((String) M416.getText()));
        M416.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(M416.getText()),M416.isChecked());
            }
        });

        final CheckBox M16A4 = mFloatingView.findViewById(R.id.M16A4);
        M16A4.setChecked(getConfig((String) M16A4.getText()));
        M16A4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(M16A4.getText()),M16A4.isChecked());
            }
        });

        final CheckBox Mk47Mutant = mFloatingView.findViewById(R.id.Mk47Mutant);
        Mk47Mutant.setChecked(getConfig((String) Mk47Mutant.getText()));
        Mk47Mutant.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Mk47Mutant.getText()),Mk47Mutant.isChecked());
            }
        });

        final CheckBox G36C = mFloatingView.findViewById(R.id.G36C);
        G36C.setChecked(getConfig((String) G36C.getText()));
        G36C.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(G36C.getText()),G36C.isChecked());
            }
        });

        final CheckBox QBZ = mFloatingView.findViewById(R.id.QBZ);
        QBZ.setChecked(getConfig((String) QBZ.getText()));
        QBZ.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(QBZ.getText()),QBZ.isChecked());
            }
        });

        final CheckBox AKM = mFloatingView.findViewById(R.id.AKM);
        AKM.setChecked(getConfig((String) AKM.getText()));
        AKM.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(AKM.getText()),AKM.isChecked());
            }
        });

        final CheckBox Groza = mFloatingView.findViewById(R.id.Groza);
        Groza.setChecked(getConfig((String) Groza.getText()));
        Groza.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Groza.getText()),Groza.isChecked());
            }
        });

        final CheckBox S12K = mFloatingView.findViewById(R.id.S12K);
        S12K.setChecked(getConfig((String) S12K.getText()));
        S12K.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(S12K.getText()),S12K.isChecked());
            }
        });

        final CheckBox DBS = mFloatingView.findViewById(R.id.DBS);
        DBS.setChecked(getConfig((String) DBS.getText()));
        DBS.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(DBS.getText()),DBS.isChecked());
            }
        });

        final CheckBox S686 = mFloatingView.findViewById(R.id.S686);
        S686.setChecked(getConfig((String) S686.getText()));
        S686.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(S686.getText()),S686.isChecked());
            }
        });

        final CheckBox S1897 = mFloatingView.findViewById(R.id.S1897);
        S1897.setChecked(getConfig((String) S1897.getText()));
        S1897.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(S1897.getText()),S1897.isChecked());
            }
        });

        final CheckBox SawedOff = mFloatingView.findViewById(R.id.SawedOff);
        SawedOff.setChecked(getConfig((String) SawedOff.getText()));
        SawedOff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(SawedOff.getText()),SawedOff.isChecked());
            }
        });

        final CheckBox TommyGun = mFloatingView.findViewById(R.id.TommyGun);
        TommyGun.setChecked(getConfig((String) TommyGun.getText()));
        TommyGun.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(TommyGun.getText()),TommyGun.isChecked());
            }
        });

        final CheckBox MP5K = mFloatingView.findViewById(R.id.MP5K);
        MP5K.setChecked(getConfig((String) MP5K.getText()));
        MP5K.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(MP5K.getText()),MP5K.isChecked());
            }
        });

        final CheckBox Vector = mFloatingView.findViewById(R.id.Vector);
        Vector.setChecked(getConfig((String) Vector.getText()));
        Vector.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Vector.getText()),Vector.isChecked());
            }
        });

        final CheckBox Uzi = mFloatingView.findViewById(R.id.Uzi);
        Uzi.setChecked(getConfig((String) Uzi.getText()));
        Uzi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Uzi.getText()),Uzi.isChecked());
            }
        });

        final CheckBox R1895 = mFloatingView.findViewById(R.id.R1895);
        R1895.setChecked(getConfig((String) R1895.getText()));
        R1895.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(R1895.getText()),R1895.isChecked());
            }
        });

        final CheckBox Vz61 = mFloatingView.findViewById(R.id.Vz61);
        Vz61.setChecked(getConfig((String) Vz61.getText()));
        Vz61.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Vz61.getText()),Vz61.isChecked());
            }
        });

        final CheckBox P92 = mFloatingView.findViewById(R.id.P92);
        P92.setChecked(getConfig((String) P92.getText()));
        P92.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(P92.getText()),P92.isChecked());
            }
        });

        final CheckBox P18C = mFloatingView.findViewById(R.id.P18C);
        P18C.setChecked(getConfig((String) P18C.getText()));
        P18C.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(P18C.getText()),P18C.isChecked());
            }
        });

        final CheckBox R45 = mFloatingView.findViewById(R.id.R45);
        R45.setChecked(getConfig((String) R45.getText()));
        R45.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(R45.getText()),R45.isChecked());
            }
        });

        final CheckBox P1911 = mFloatingView.findViewById(R.id.P1911);
        P1911.setChecked(getConfig((String) P1911.getText()));
        P1911.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(P1911.getText()),P1911.isChecked());
            }
        });

        final CheckBox DesertEagle = mFloatingView.findViewById(R.id.DesertEagle);
        DesertEagle.setChecked(getConfig((String) DesertEagle.getText()));
        DesertEagle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(DesertEagle.getText()),DesertEagle.isChecked());
            }
        });

        final CheckBox Sickle = mFloatingView.findViewById(R.id.Sickle);
        Sickle.setChecked(getConfig((String) Sickle.getText()));
        Sickle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Sickle.getText()),Sickle.isChecked());
            }
        });

        final CheckBox Machete = mFloatingView.findViewById(R.id.Machete);
        Machete.setChecked(getConfig((String) Machete.getText()));
        Machete.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Machete.getText()),Machete.isChecked());
            }
        });

        final CheckBox Pan = mFloatingView.findViewById(R.id.Pan);
        Pan.setChecked(getConfig((String) Pan.getText()));
        Pan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Pan.getText()),Pan.isChecked());
            }
        });

        final CheckBox Mk14 = mFloatingView.findViewById(R.id.Mk14);
        Mk14.setChecked(getConfig((String) Mk14.getText()));
        Mk14.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Mk14.getText()),Mk14.isChecked());
            }
        });

        final CheckBox sst = mFloatingView.findViewById(R.id.sst);
        sst.setChecked(getConfig((String) sst.getText()));
        sst.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(sst.getText()),sst.isChecked());
            }
        });

        final CheckBox ffACP = mFloatingView.findViewById(R.id.ffACP);
        ffACP.setChecked(getConfig((String) ffACP.getText()));
        ffACP.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(ffACP.getText()),ffACP.isChecked());
            }
        });

        final CheckBox ffs = mFloatingView.findViewById(R.id.ffs);
        ffs.setChecked(getConfig((String) ffs.getText()));
        ffs.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(ffs.getText()),ffs.isChecked());
            }
        });

        final CheckBox nmm = mFloatingView.findViewById(R.id.nmm);
        nmm.setChecked(getConfig((String) nmm.getText()));
        nmm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(nmm.getText()),nmm.isChecked());
            }
        });

        final CheckBox tzzMagnum = mFloatingView.findViewById(R.id.tzzMagnum);
        tzzMagnum.setChecked(getConfig((String) tzzMagnum.getText()));
        tzzMagnum.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(tzzMagnum.getText()),tzzMagnum.isChecked());
            }
        });

        final CheckBox otGuage = mFloatingView.findViewById(R.id.otGuage);
        otGuage.setChecked(getConfig((String) otGuage.getText()));
        otGuage.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(otGuage.getText()),otGuage.isChecked());
            }
        });

        final CheckBox Choke = mFloatingView.findViewById(R.id.Choke);
        Choke.setChecked(getConfig((String) Choke.getText()));
        Choke.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Choke.getText()),Choke.isChecked());
            }
        });

        final CheckBox SniperCompensator = mFloatingView.findViewById(R.id.SniperCompensator);
        SniperCompensator.setChecked(getConfig((String) SniperCompensator.getText()));
        SniperCompensator.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(SniperCompensator.getText()),SniperCompensator.isChecked());
            }
        });

        final CheckBox DP28 = mFloatingView.findViewById(R.id.DP28);
        DP28.setChecked(getConfig((String) DP28.getText()));
        DP28.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(DP28.getText()),DP28.isChecked());
            }
        });

        final CheckBox M249 = mFloatingView.findViewById(R.id.M249);
        M249.setChecked(getConfig((String) M249.getText()));
        M249.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(M249.getText()),M249.isChecked());
            }
        });

        final CheckBox Grenade = mFloatingView.findViewById(R.id.Grenade);
        Grenade.setChecked(getConfig((String) Grenade.getText()));
        Grenade.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Grenade.getText()),Grenade.isChecked());
            }
        });

        final CheckBox Smoke = mFloatingView.findViewById(R.id.Smoke);
        Smoke.setChecked(getConfig((String) Smoke.getText()));
        Smoke.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Smoke.getText()),Smoke.isChecked());
            }
        });

        final CheckBox Molotov = mFloatingView.findViewById(R.id.Molotov);
        Molotov.setChecked(getConfig((String) Molotov.getText()));
        Molotov.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Molotov.getText()),Molotov.isChecked());
            }
        });

        final CheckBox Painkiller = mFloatingView.findViewById(R.id.Painkiller);
        Painkiller.setChecked(getConfig((String) Painkiller.getText()));
        Painkiller.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Painkiller.getText()),Painkiller.isChecked());
            }
        });

        final CheckBox Adrenaline = mFloatingView.findViewById(R.id.Adrenaline);
        Adrenaline.setChecked(getConfig((String) Adrenaline.getText()));
        Adrenaline.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Adrenaline.getText()),Adrenaline.isChecked());
            }
        });

        final CheckBox EnergyDrink = mFloatingView.findViewById(R.id.EnergyDrink);
        EnergyDrink.setChecked(getConfig((String) EnergyDrink.getText()));
        EnergyDrink.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(EnergyDrink.getText()),EnergyDrink.isChecked());
            }
        });

        final CheckBox FirstAidKit = mFloatingView.findViewById(R.id.FirstAidKit);
        FirstAidKit.setChecked(getConfig((String) FirstAidKit.getText()));
        FirstAidKit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(FirstAidKit.getText()),FirstAidKit.isChecked());
            }
        });

        final CheckBox Bandage = mFloatingView.findViewById(R.id.Bandage);
        Bandage.setChecked(getConfig((String) Bandage.getText()));
        Bandage.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Bandage.getText()),Bandage.isChecked());
            }
        });

        final CheckBox Medkit = mFloatingView.findViewById(R.id.Medkit);
        Medkit.setChecked(getConfig((String) Medkit.getText()));
        Medkit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Medkit.getText()),Medkit.isChecked());
            }
        });

        final CheckBox FlareGun = mFloatingView.findViewById(R.id.FlareGun);
        FlareGun.setChecked(getConfig((String) FlareGun.getText()));
        FlareGun.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(FlareGun.getText()),FlareGun.isChecked());
            }
        });

        final CheckBox GullieSuit = mFloatingView.findViewById(R.id.GullieSuit);
        GullieSuit.setChecked(getConfig((String) GullieSuit.getText()));
        GullieSuit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(GullieSuit.getText()),GullieSuit.isChecked());
            }
        });

        final CheckBox UMP = mFloatingView.findViewById(R.id.UMP);
        UMP.setChecked(getConfig((String) UMP.getText()));
        UMP.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(UMP.getText()),UMP.isChecked());
            }
        });

        final CheckBox Bizon = mFloatingView.findViewById(R.id.Bizon);
        Bizon.setChecked(getConfig((String) Bizon.getText()));
        Bizon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Bizon.getText()),Bizon.isChecked());
            }
        });

        final CheckBox CompensatorSMG = mFloatingView.findViewById(R.id.CompensatorSMG);
        CompensatorSMG.setChecked(getConfig((String) CompensatorSMG.getText()));
        CompensatorSMG.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(CompensatorSMG.getText()),CompensatorSMG.isChecked());
            }
        });

        final CheckBox FlashHiderSMG = mFloatingView.findViewById(R.id.FlashHiderSMG);
        FlashHiderSMG.setChecked(getConfig((String) FlashHiderSMG.getText()));
        FlashHiderSMG.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(FlashHiderSMG.getText()),FlashHiderSMG.isChecked());
            }
        });

        final CheckBox FlashHiderAr = mFloatingView.findViewById(R.id.FlashHiderAr);
        FlashHiderAr.setChecked(getConfig((String) FlashHiderAr.getText()));
        FlashHiderAr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(FlashHiderAr.getText()),FlashHiderAr.isChecked());
            }
        });

        final CheckBox ArCompensator = mFloatingView.findViewById(R.id.ArCompensator);
        ArCompensator.setChecked(getConfig((String) ArCompensator.getText()));
        ArCompensator.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(ArCompensator.getText()),ArCompensator.isChecked());
            }
        });

        final CheckBox TacticalStock = mFloatingView.findViewById(R.id.TacticalStock);
        TacticalStock.setChecked(getConfig((String) TacticalStock.getText()));
        TacticalStock.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(TacticalStock.getText()),TacticalStock.isChecked());
            }
        });

        final CheckBox Duckbill = mFloatingView.findViewById(R.id.Duckbill);
        Duckbill.setChecked(getConfig((String) Duckbill.getText()));
        Duckbill.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Duckbill.getText()),Duckbill.isChecked());
            }
        });

        final CheckBox FlashHiderSniper = mFloatingView.findViewById(R.id.FlashHiderSniper);
        FlashHiderSniper.setChecked(getConfig((String) FlashHiderSniper.getText()));
        FlashHiderSniper.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(FlashHiderSniper.getText()),FlashHiderSniper.isChecked());
            }
        });

        final CheckBox SuppressorSMG = mFloatingView.findViewById(R.id.SuppressorSMG);
        SuppressorSMG.setChecked(getConfig((String) SuppressorSMG.getText()));
        SuppressorSMG.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(SuppressorSMG.getText()),SuppressorSMG.isChecked());
            }
        });

        final CheckBox HalfGrip = mFloatingView.findViewById(R.id.HalfGrip);
        HalfGrip.setChecked(getConfig((String) HalfGrip.getText()));
        HalfGrip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(HalfGrip.getText()),HalfGrip.isChecked());
            }
        });

        final CheckBox StockMicroUZI = mFloatingView.findViewById(R.id.StockMicroUZI);
        StockMicroUZI.setChecked(getConfig((String) StockMicroUZI.getText()));
        StockMicroUZI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(StockMicroUZI.getText()),StockMicroUZI.isChecked());
            }
        });

        final CheckBox SuppressorSniper = mFloatingView.findViewById(R.id.SuppressorSniper);
        SuppressorSniper.setChecked(getConfig((String) SuppressorSniper.getText()));
        SuppressorSniper.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(SuppressorSniper.getText()),SuppressorSniper.isChecked());
            }
        });

        final CheckBox SuppressorAr = mFloatingView.findViewById(R.id.SuppressorAr);
        SuppressorAr.setChecked(getConfig((String) SuppressorAr.getText()));
        SuppressorAr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(SuppressorAr.getText()),SuppressorAr.isChecked());
            }
        });

        final CheckBox ExQdSniper = mFloatingView.findViewById(R.id.ExQdSniper);
        ExQdSniper.setChecked(getConfig((String) ExQdSniper.getText()));
        ExQdSniper.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(ExQdSniper.getText()),ExQdSniper.isChecked());
            }
        });

        final CheckBox QdSMG = mFloatingView.findViewById(R.id.QdSMG);
        QdSMG.setChecked(getConfig((String) QdSMG.getText()));
        QdSMG.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(QdSMG.getText()),QdSMG.isChecked());
            }
        });

        final CheckBox ExSMG = mFloatingView.findViewById(R.id.ExSMG);
        ExSMG.setChecked(getConfig((String) ExSMG.getText()));
        ExSMG.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(ExSMG.getText()),ExSMG.isChecked());
            }
        });

        final CheckBox QdSniper = mFloatingView.findViewById(R.id.QdSniper);
        QdSniper.setChecked(getConfig((String) QdSniper.getText()));
        QdSniper.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(QdSniper.getText()),QdSniper.isChecked());
            }
        });

        final CheckBox ExSniper = mFloatingView.findViewById(R.id.ExSniper);
        ExSniper.setChecked(getConfig((String) ExSniper.getText()));
        ExSniper.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(ExSniper.getText()),ExSniper.isChecked());
            }
        });

        final CheckBox ExAr = mFloatingView.findViewById(R.id.ExAr);
        ExAr.setChecked(getConfig((String) ExAr.getText()));
        ExAr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(ExAr.getText()),ExAr.isChecked());
            }
        });

        final CheckBox ExQdAr = mFloatingView.findViewById(R.id.ExQdAr);
        ExQdAr.setChecked(getConfig((String) ExQdAr.getText()));
        ExQdAr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(ExQdAr.getText()),ExQdAr.isChecked());
            }
        });

        final CheckBox QdAr = mFloatingView.findViewById(R.id.QdAr);
        QdAr.setChecked(getConfig((String) QdAr.getText()));
        QdAr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(QdAr.getText()),QdAr.isChecked());
            }
        });

        final CheckBox ExQdSMG = mFloatingView.findViewById(R.id.ExQdSMG);
        ExQdSMG.setChecked(getConfig((String) ExQdSMG.getText()));
        ExQdSMG.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(ExQdSMG.getText()),ExQdSMG.isChecked());
            }
        });

        final CheckBox QuiverCrossBow = mFloatingView.findViewById(R.id.QuiverCrossBow);
        QuiverCrossBow.setChecked(getConfig((String) QuiverCrossBow.getText()));
        QuiverCrossBow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(QuiverCrossBow.getText()),QuiverCrossBow.isChecked());
            }
        });

        final CheckBox BulletLoop = mFloatingView.findViewById(R.id.BulletLoop);
        BulletLoop.setChecked(getConfig((String) BulletLoop.getText()));
        BulletLoop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(BulletLoop.getText()),BulletLoop.isChecked());
            }
        });

        final CheckBox ThumbGrip = mFloatingView.findViewById(R.id.ThumbGrip);
        ThumbGrip.setChecked(getConfig((String) ThumbGrip.getText()));
        ThumbGrip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(ThumbGrip.getText()),ThumbGrip.isChecked());
            }
        });

        final CheckBox LaserSight = mFloatingView.findViewById(R.id.LaserSight);
        LaserSight.setChecked(getConfig((String) LaserSight.getText()));
        LaserSight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(LaserSight.getText()),LaserSight.isChecked());
            }
        });

        final CheckBox AngledGrip = mFloatingView.findViewById(R.id.AngledGrip);
        AngledGrip.setChecked(getConfig((String) AngledGrip.getText()));
        AngledGrip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(AngledGrip.getText()),AngledGrip.isChecked());
            }
        });

        final CheckBox LightGrip = mFloatingView.findViewById(R.id.LightGrip);
        LightGrip.setChecked(getConfig((String) LightGrip.getText()));
        LightGrip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(LightGrip.getText()),LightGrip.isChecked());
            }
        });

        final CheckBox VerticalGrip = mFloatingView.findViewById(R.id.VerticalGrip);
        VerticalGrip.setChecked(getConfig((String) VerticalGrip.getText()));
        VerticalGrip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(VerticalGrip.getText()),VerticalGrip.isChecked());
            }
        });

        final CheckBox GasCan = mFloatingView.findViewById(R.id.GasCan);
        GasCan.setChecked(getConfig((String) GasCan.getText()));
        GasCan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(GasCan.getText()),GasCan.isChecked());
            }
        });

        final CheckBox Arrow = mFloatingView.findViewById(R.id.Arrow);
        Arrow.setChecked(getConfig((String) Arrow.getText()));
        Arrow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Arrow.getText()),Arrow.isChecked());
            }
        });

        final CheckBox CrossBow = mFloatingView.findViewById(R.id.CrossBow);
        CrossBow.setChecked(getConfig((String) CrossBow.getText()));
        CrossBow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(CrossBow.getText()),CrossBow.isChecked());
            }
        });

        final CheckBox Baglvl1 = mFloatingView.findViewById(R.id.Baglvl1);
        Baglvl1.setChecked(getConfig((String) Baglvl1.getText()));
        Baglvl1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Baglvl1.getText()),Baglvl1.isChecked());
            }
        });

        final CheckBox Baglvl2 = mFloatingView.findViewById(R.id.Baglvl2);
        Baglvl2.setChecked(getConfig((String) Baglvl2.getText()));
        Baglvl2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Baglvl2.getText()),Baglvl2.isChecked());
            }
        });

        final CheckBox Baglvl3 = mFloatingView.findViewById(R.id.Baglvl3);
        Baglvl3.setChecked(getConfig((String) Baglvl3.getText()));
        Baglvl3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Baglvl3.getText()),Baglvl3.isChecked());
            }
        });

        final CheckBox Helmetlvl1 = mFloatingView.findViewById(R.id.Helmetlvl1);
        Helmetlvl1.setChecked(getConfig((String) Helmetlvl1.getText()));
        Helmetlvl1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Helmetlvl1.getText()),Helmetlvl1.isChecked());
            }
        });

        final CheckBox Helmetlvl2 = mFloatingView.findViewById(R.id.Helmetlvl2);
        Helmetlvl2.setChecked(getConfig((String) Helmetlvl2.getText()));
        Helmetlvl2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Helmetlvl2.getText()),Helmetlvl2.isChecked());
            }
        });

        final CheckBox Helmetlvl3 = mFloatingView.findViewById(R.id.Helmetlvl3);
        Helmetlvl3.setChecked(getConfig((String) Helmetlvl3.getText()));
        Helmetlvl3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Helmetlvl3.getText()),Helmetlvl3.isChecked());
            }
        });

        final CheckBox Vestlvl1 = mFloatingView.findViewById(R.id.Vestlvl1);
        Vestlvl1.setChecked(getConfig((String) Vestlvl1.getText()));
        Vestlvl1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Vestlvl1.getText()),Vestlvl1.isChecked());
            }
        });

        final CheckBox Vestlvl2 = mFloatingView.findViewById(R.id.Vestlvl2);
        Vestlvl2.setChecked(getConfig((String) Vestlvl2.getText()));
        Vestlvl2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Vestlvl2.getText()),Vestlvl2.isChecked());
            }
        });

        final CheckBox Vestlvl3 = mFloatingView.findViewById(R.id.Vestlvl3);
        Vestlvl3.setChecked(getConfig((String) Vestlvl3.getText()));
        Vestlvl3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Vestlvl3.getText()),Vestlvl3.isChecked());
            }
        });

        final CheckBox Stung = mFloatingView.findViewById(R.id.Stung);
        Stung.setChecked(getConfig((String) Stung.getText()));
        Stung.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Stung.getText()),Stung.isChecked());
            }
        });

        final CheckBox Crowbar = mFloatingView.findViewById(R.id.Crowbar);
        Crowbar.setChecked(getConfig((String) Crowbar.getText()));
        Crowbar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Crowbar.getText()),Crowbar.isChecked());
            }
        });

        final SeekBar fps = mFloatingView.findViewById(R.id.fps);
        fps.setProgress(getFps());
        ESPView.ChangeFps(getFps());
        fps.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int fpsms=fps.getProgress();
                setFps(fpsms);
                ESPView.ChangeFps(fpsms);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //write custom code to on start progress
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        final CheckBox IconDistanceName = mFloatingView.findViewById(R.id.dual);
        final CheckBox Icon = mFloatingView.findViewById(R.id.meterial);
        final CheckBox IconDistance = mFloatingView.findViewById(R.id.meterialdistance);

        Icon.setChecked(getConfig((String) Icon.getText()));
        Icon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Icon.getText()), Icon.isChecked());
                if (isChecked) {
                    IconDistanceName.setChecked(false);
                    IconDistance.setChecked(false);
                }
            }
        });

        IconDistance.setChecked(getConfig((String) IconDistance.getText()));
        IconDistance.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(IconDistance.getText()), IconDistance.isChecked());
                if (isChecked) {
                    IconDistanceName.setChecked(false);
                    Icon.setChecked(false);
                }
            }
        });

        IconDistanceName.setChecked(getConfig((String) IconDistanceName.getText()));
        IconDistanceName.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(IconDistanceName.getText()), IconDistanceName.isChecked());
                if (isChecked) {
                    Icon.setChecked(false);
                    IconDistance.setChecked(false);
                }
            }
        });

        final TextView positionText = mFloatingView.findViewById(R.id.positionText);
        final SeekBar position = mFloatingView.findViewById(R.id.position);
        final TextView sizeText = mFloatingView.findViewById(R.id.SizeText);
        final SeekBar size = mFloatingView.findViewById(R.id.Size);

        final TextView itemSizeText = mFloatingView.findViewById(R.id.itemSizeText);
        final SeekBar itemSize = mFloatingView.findViewById(R.id.itemSize);
        final TextView itemPositionText = mFloatingView.findViewById(R.id.itemPositionText);
        final SeekBar itemPosition = mFloatingView.findViewById(R.id.itemPosition);

        itemPosition.setProgress(getItemPosition());
        String bb = String.valueOf(getItemPosition());
        itemPositionText.setText(bb);
        ESPView.ChangeitemPosition(getItemPosition());
        itemPosition.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int pos=itemPosition.getProgress();
                setItemPosition(pos);
                ESPView.ChangeitemPosition(pos);
                String a = String.valueOf(pos);
                itemPositionText.setText(a);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        itemSize.setProgress(getItemSize());
        String bbb = String.valueOf(getItemSize());
        itemSizeText.setText(bbb);
        ESPView.ChangeitemSize(getItemSize());
        itemSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int pos=itemSize.getProgress();
                setItemSIze(pos);
                ESPView.ChangeitemSize(pos);
                String a = String.valueOf(pos);
                itemSizeText.setText(a);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        position.setProgress(getPosition());
        String b = String.valueOf(getPosition());
        positionText.setText(b);
        ESPView.ChangePosition(getPosition());
        position.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int pos=position.getProgress();
                setPosition(pos);
                ESPView.ChangePosition(pos);
                String a = String.valueOf(pos);
                positionText.setText(a);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        size.setProgress(getSize());
        String c = String.valueOf(getSize());
        sizeText.setText(c);
        ESPView.ChangeSize(getSize());
        size.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int pos=size.getProgress();
                setSize(pos);
                ESPView.ChangeSize(pos);
                String a = String.valueOf(pos);
                sizeText.setText(a);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        final SeekBar range = mFloatingView.findViewById(R.id.range);
        range.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Range(range.getProgress());
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        final RadioGroup aimby=mFloatingView.findViewById(R.id.aimby);
        aimby.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int chkdId=aimby.getCheckedRadioButtonId();
                RadioButton btn=mFloatingView.findViewById(chkdId);
                AimBy(Integer.parseInt(btn.getTag().toString()));
            }
        });
        final RadioGroup aimwhen=mFloatingView.findViewById(R.id.aimwhen);
        aimwhen.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int chkdId=aimwhen.getCheckedRadioButtonId();
                RadioButton btn=mFloatingView.findViewById(chkdId);
                AimWhen(Integer.parseInt(btn.getTag().toString()));
            }
        });
        final RadioGroup aimbotmode=mFloatingView.findViewById(R.id.aimbotmode);
        aimbotmode.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int chkdId=aimbotmode.getCheckedRadioButtonId();
                RadioButton btn=mFloatingView.findViewById(chkdId);
                Target(Integer.parseInt(btn.getTag().toString()));
            }
        });
        final CheckBox aimbot = mFloatingView.findViewById(R.id.aimbot);
		aimbot.setChecked(getConfig((String) aimbot.getText()));
        aimbot.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if (isChecked) {
					setValue(String.valueOf(aimbot.getText()), aimbot.isChecked());
					floatAimbot=true;
					startFloatAimbot();
				} else {
					setValue(String.valueOf(aimbot.getText()), aimbot.isChecked());
					SettingValue(11,false);
					floatAimbot=false;
					stopFloatAimbot();
				} 
            }
        });
        final CheckBox aimknocked = mFloatingView.findViewById(R.id.aimknocked);
        aimknocked.setChecked(getConfig((String) aimknocked.getText()));
        SettingValue(13,getConfig((String) aimknocked.getText()));
        aimknocked.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(aimknocked.getText()), aimknocked.isChecked());
                SettingValue(13,aimknocked.isChecked());
            }
        });
        
        
		
		
		final Switch ZeroRecoil = mFloatingView.findViewById(R.id.ZeroRecoil);
  ZeroRecoil.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
   @Override
   public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
    SettingValue(39, ZeroRecoil.isChecked());
   }
  });

final Switch HitX = mFloatingView.findViewById(R.id.HitX);
  HitX.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
   @Override
   public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
    SettingValue(40, HitX.isChecked());
   }
  });
  
  final Switch NoShake = mFloatingView.findViewById(R.id.NoShake);
  NoShake.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
   @Override
   public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
    SettingValue(41, NoShake.isChecked());
   }
  });
  
  final Switch LessRecoil = mFloatingView.findViewById(R.id.LessRecoil);
  LessRecoil.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
   @Override
   public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
    SettingValue(35, LessRecoil.isChecked());
   }
  });
  
  final Switch InstantHit = mFloatingView.findViewById(R.id.InstantHit);
  InstantHit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
   @Override
   public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
    SettingValue(36, InstantHit.isChecked());
   }
  });
  
  
  final Switch FastShootInterval = mFloatingView.findViewById(R.id.FastShootInterval);
  FastShootInterval.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
   @Override
   public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
    SettingValue(37, FastShootInterval.isChecked());
   }
  });
  
  
  final Switch SmallCrosshair = mFloatingView.findViewById(R.id.SmallCrosshair);
  SmallCrosshair.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
   @Override
   public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
    SettingValue(38, SmallCrosshair.isChecked());
   }
  });
  
  
  final Switch FastSwitchWeapon = mFloatingView.findViewById(R.id.FastSwitchWeapon);
  FastSwitchWeapon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
   @Override
   public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
    SettingValue(42, FastSwitchWeapon.isChecked());
   }
  });
  
 
			
			
final Switch bypass = mFloatingView.findViewById(R.id.bypass);
        bypass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

					if (isChecked){
					Toast.makeText(getApplicationContext(), "Activating Logo Bypass!", Toast.LENGTH_SHORT).show();
						RunCPP("/bypass");
					Toast.makeText(getApplicationContext(), "Logo Bypass Running!", Toast.LENGTH_SHORT).show();
					} else {
						RunCPP("/bypass");


					}

				}
			});
			
final Switch spawn = mFloatingView.findViewById(R.id.spawn);
        spawn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

					if (isChecked){
					Toast.makeText(getApplicationContext(), "Activating Spawn Bypass!", Toast.LENGTH_SHORT).show();
						RunCPP("/island");
					Toast.makeText(getApplicationContext(), "Spawn Bypass Running!", Toast.LENGTH_SHORT).show();
					} else {
						RunCPP("/island");


					}

				}
			});
			
			final Switch magic = mFloatingView.findViewById(R.id.magic);
        magic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

					if (isChecked){
						RunCPP("/trinity 877 1");
					} else {
						RunCPP("/trinity 877 2");


					}

				}
			});
			
final Switch stands = mFloatingView.findViewById(R.id.stands);
        stands.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

					if (isChecked){
						RunCPP("/trinity 87 1");
					} else {
						RunCPP("/trinity 87 2");


					}

				}
			});
			
			
			
		
			
			final Switch isESP = mFloatingView.findViewById(R.id.isESP);
        isESP.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					
					
					Toast.makeText(getApplicationContext(), "Wait 15sec then use other feture", Toast.LENGTH_SHORT).show();
					if (isChecked){
					 startService(new Intent(getApplicationContext(), Overlay.class));
					} else {
					  stopService(new Intent(getApplicationContext(), Overlay.class));
					}

				}
			});
			
		
		
		
			
			
			}
		
 
 
	public void RunCPP(String path)
    {
        try
        {
            ExecuteElf("chmod 777 " + getFilesDir() + path);
            ExecuteElf(getFilesDir() + path);
            ExecuteElf("su -c chmod 777 " + getFilesDir() + path);
            ExecuteElf("su -c " + getFilesDir() + path);
        }
        catch (Exception e)
        {
        }
    }

    private void ExecuteElf(String shell)
    {
        String s=shell;
        try
        {
            Runtime.getRuntime().exec(s, null, null);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
 
	private void startFloatAimbot(){
		startService(new Intent(this, FloatAimbot.class));
	}

	private void stopFloatAimbot(){
		stopService(new Intent(this, FloatAimbot.class));
	}
	
public native void SettingValue(int setting_code,boolean value);
public native void Range(int range);
public native void Target(int target);
public native void AimBy(int aimby);
public native void AimWhen(int aimwhen);
}

class SingleTapConfirm extends GestureDetector.SimpleOnGestureListener {

    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        return true;
    }
}

