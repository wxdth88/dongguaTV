package com.ednovas.donguatv;

import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import androidx.core.view.WindowCompat;
import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // 启用边到边显示，让 WebView 可以扩展到状态栏和导航栏区域
        // 这允许全屏视频播放时覆盖整个屏幕
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        
        // 设置透明状态栏，让网页内容可以显示在状态栏下方
        getWindow().setStatusBarColor(android.graphics.Color.TRANSPARENT);
        
        // 支持刘海屏/打孔屏 - 允许内容扩展到刘海区域
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            WindowManager.LayoutParams lp = getWindow().getAttributes();
            lp.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
            getWindow().setAttributes(lp);
        }
    }
}
