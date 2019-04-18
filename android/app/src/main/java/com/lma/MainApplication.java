package com.lma;

import android.app.Application;

import com.facebook.react.ReactApplication;
import com.reactnativecommunity.netinfo.NetInfoPackage;
// import com.RNFetchBlob.RNFetchBlobPackage;
import com.BV.LinearGradient.LinearGradientPackage;
import com.imagepicker.ImagePickerPackage;
import com.oblador.vectoricons.VectorIconsPackage;
import com.swmansion.gesturehandler.react.RNGestureHandlerPackage;
// import com.facebook.reactnative.androidsdk.FBSDKPackage;
import com.imagepicker.ImagePickerPackage;
import com.airbnb.android.react.maps.MapsPackage;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;
// import com.facebook.CallbackManager;
// import com.facebook.reactnative.androidsdk.FBSDKPackage;

import java.util.Arrays;
import java.util.List;

public class MainApplication extends Application implements ReactApplication {
// 	private static CallbackManager mCallbackManager = CallbackManager.Factory.create();

//   protected static CallbackManager getCallbackManager() {
//     return mCallbackManager;
//   }

  private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
    @Override
    public boolean getUseDeveloperSupport() {
		// FacebookSdk.sdkInitialize(getApplicationContext());
      return BuildConfig.DEBUG;
    }

    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
          	new MainReactPackage(),
            new NetInfoPackage(),
            // new RNFetchBlobPackage(),
            new LinearGradientPackage(),
            new ImagePickerPackage(),
		  	// new ImagePickerPackage(),
            new VectorIconsPackage(),
            new RNGestureHandlerPackage(),
            // new FBSDKPackage(mCallbackManager),
            new MapsPackage()
      );
    }

    @Override
    protected String getJSMainModuleName() {
      return "index";
    }
  };

  @Override
  public ReactNativeHost getReactNativeHost() {
    return mReactNativeHost;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    SoLoader.init(this, /* native exopackage */ false);
  }
}
