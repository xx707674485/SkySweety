package com.xjst.skysweety.util.delegate.activity;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.PendingIntent;
import android.app.PictureInPictureParams;
import android.app.VoiceInteractor;
import android.app.assist.AssistContent;
import android.arch.lifecycle.Lifecycle;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.SharedElementCallback;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.Toolbar;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.Display;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;

import com.xjst.skysweety.util.delegate.DelegateProvider;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

public class DelegateActivity extends AppCompatActivity implements DelegateProvider<ActivityDelegate> {
    private ActivityDelegate delegate;

    public DelegateActivity() {
        super();
        delegate = this.getComponentDelegate();
        if (delegate == null) delegate = new DefaultActivityDelegate();
        delegate.initialized();
    }

    @Override
    public void setTheme(int resid) {
        super.setTheme(resid);
        delegate.setTheme(resid);
    }

    @Nullable
    @Override
    public ActionBar getSupportActionBar() {
        ActionBar actionBar = delegate.getSupportActionBar();
        return actionBar == null ? super.getSupportActionBar() : actionBar;
    }

    @Override
    public void setSupportActionBar(@Nullable Toolbar toolbar) {
        delegate.setSupportActionBar(toolbar);
        super.setSupportActionBar(toolbar);
    }

    @NonNull
    @Override
    public MenuInflater getMenuInflater() {
        MenuInflater inflater = delegate.getMenuInflater();
        return inflater == null ? super.getMenuInflater() : inflater;
    }

    @Override
    public void setContentView(int layoutResID) {
        delegate.setContentView(layoutResID);
        super.setContentView(layoutResID);
    }

    @Override
    public void setContentView(View view) {
        delegate.setContentView(view);
        super.setContentView(view);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        delegate.setContentView(view, params);
        super.setContentView(view, params);
    }

    @Override
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        delegate.addContentView(view, params);
        super.addContentView(view, params);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        delegate.onConfigurationChanged(newConfig);
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public <T extends View> T findViewById(int id) {
        T t = delegate.findViewById(id);
        return t == null ? super.findViewById(id) : t;
    }

    @Override
    public boolean supportRequestWindowFeature(int featureId) {
        Boolean aBoolean = delegate.supportRequestWindowFeature(featureId);
        return aBoolean == null ? super.supportRequestWindowFeature(featureId) : aBoolean;
    }

    @Override
    public void supportInvalidateOptionsMenu() {
        delegate.supportInvalidateOptionsMenu();
        super.supportInvalidateOptionsMenu();
    }

    @Override
    public void invalidateOptionsMenu() {
        delegate.invalidateOptionsMenu();
        super.invalidateOptionsMenu();
    }

    @Override
    public void onSupportActionModeStarted(@NonNull ActionMode mode) {
        delegate.onSupportActionModeStarted(mode);
        super.onSupportActionModeStarted(mode);
    }

    @Override
    public void onSupportActionModeFinished(@NonNull ActionMode mode) {
        delegate.onSupportActionModeFinished(mode);
        super.onSupportActionModeFinished(mode);
    }

    @Nullable
    @Override
    public ActionMode onWindowStartingSupportActionMode(@NonNull ActionMode.Callback callback) {
        delegate.onWindowStartingSupportActionMode(callback);
        return super.onWindowStartingSupportActionMode(callback);
    }

    @Nullable
    @Override
    public ActionMode startSupportActionMode(@NonNull ActionMode.Callback callback) {
        ActionMode actionMode = delegate.startSupportActionMode(callback);
        return actionMode == null ? super.startSupportActionMode(callback) : actionMode;
    }


    @Override
    public void onCreateSupportNavigateUpTaskStack(@NonNull TaskStackBuilder builder) {
        delegate.onCreateSupportNavigateUpTaskStack(builder);
        super.onCreateSupportNavigateUpTaskStack(builder);
    }

    @Override
    public void onPrepareSupportNavigateUpTaskStack(@NonNull TaskStackBuilder builder) {
        delegate.onPrepareSupportNavigateUpTaskStack(builder);
        super.onPrepareSupportNavigateUpTaskStack(builder);
    }

    @Override
    public boolean onSupportNavigateUp() {
        Boolean aBoolean = delegate.onSupportNavigateUp();
        return aBoolean == null ? super.onSupportNavigateUp() : aBoolean;
    }

    @Nullable
    @Override
    public Intent getSupportParentActivityIntent() {
        Intent intent = delegate.getSupportParentActivityIntent();
        return intent == null ? super.getSupportParentActivityIntent() : intent;
    }

    @Override
    public boolean supportShouldUpRecreateTask(@NonNull Intent targetIntent) {
        Boolean aBoolean = delegate.supportShouldUpRecreateTask(targetIntent);
        return aBoolean == null ? super.supportShouldUpRecreateTask(targetIntent) : aBoolean;
    }

    @Override
    public void supportNavigateUpTo(@NonNull Intent upIntent) {
        delegate.supportNavigateUpTo(upIntent);
        super.supportNavigateUpTo(upIntent);
    }

    @Override
    public void onContentChanged() {
        delegate.onContentChanged();
        super.onContentChanged();
    }


    @Nullable
    @Override
    public ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        ActionBarDrawerToggle.Delegate drawerToggleDelegate = delegate.getDrawerToggleDelegate();
        return drawerToggleDelegate == null ? super.getDrawerToggleDelegate() : drawerToggleDelegate;
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        Boolean aBoolean = delegate.onMenuOpened(featureId, menu);
        return aBoolean == null ? super.onMenuOpened(featureId, menu) : aBoolean;
    }

    @Override
    public void onPanelClosed(int featureId, Menu menu) {
        delegate.onPanelClosed(featureId, menu);
        super.onPanelClosed(featureId, menu);
    }

    @NonNull
    @Override
    public AppCompatDelegate getDelegate() {
        AppCompatDelegate appCompatDelegate = delegate.getDelegate();
        return appCompatDelegate == null ? super.getDelegate() : appCompatDelegate;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        Boolean aBoolean = delegate.dispatchKeyEvent(event);
        return aBoolean == null ? super.dispatchKeyEvent(event) : aBoolean;
    }

    @Override
    public Resources getResources() {
        Resources resources = delegate.getResources();
        return resources == null ? super.getResources() : resources;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Boolean aBoolean = delegate.onKeyDown(keyCode, event);
        return aBoolean == null ? super.onKeyDown(keyCode, event) : aBoolean;
    }

    @Override
    public void openOptionsMenu() {
        delegate.openOptionsMenu();
        super.openOptionsMenu();
    }

    @Override
    public void closeOptionsMenu() {
        delegate.closeOptionsMenu();
        super.closeOptionsMenu();
    }

    @Override
    public final void onBackPressed() {
        delegate.onBackPressed();
    }

    @Override
    public void supportFinishAfterTransition() {
        delegate.supportFinishAfterTransition();
        super.supportFinishAfterTransition();
    }

    @Override
    public void setEnterSharedElementCallback(SharedElementCallback callback) {
        delegate.setEnterSharedElementCallback(callback);
        super.setEnterSharedElementCallback(callback);
    }

    @Override
    public void setExitSharedElementCallback(SharedElementCallback listener) {
        delegate.setExitSharedElementCallback(listener);
        super.setExitSharedElementCallback(listener);
    }

    @Override
    public void supportPostponeEnterTransition() {
        delegate.supportPostponeEnterTransition();
        super.supportPostponeEnterTransition();
    }

    @Override
    public void supportStartPostponedEnterTransition() {
        delegate.supportStartPostponedEnterTransition();
        super.supportStartPostponedEnterTransition();
    }

    @Override
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        delegate.onMultiWindowModeChanged(isInMultiWindowMode);
        super.onMultiWindowModeChanged(isInMultiWindowMode);
    }

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
        delegate.onPictureInPictureModeChanged(isInPictureInPictureMode);
        super.onPictureInPictureModeChanged(isInPictureInPictureMode);
    }

    @Override
    public Lifecycle getLifecycle() {
        delegate.getLifecycle();
        return super.getLifecycle();
    }

    @Override
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        delegate.onCreatePanelMenu(featureId, menu);
        return super.onCreatePanelMenu(featureId, menu);
    }

    @Override
    public void onLowMemory() {
        delegate.onLowMemory();
        super.onLowMemory();
    }

    @Override
    public void onStateNotSaved() {
        delegate.onStateNotSaved();
        super.onStateNotSaved();
    }

    @Override
    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        Boolean aBoolean = delegate.onPreparePanel(featureId, view, menu);
        return aBoolean == null ? super.onPreparePanel(featureId, view, menu) : aBoolean;
    }


    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        Object o = delegate.onRetainCustomNonConfigurationInstance();
        return o == null ? super.onRetainCustomNonConfigurationInstance() : o;
    }

    @Override
    public Object getLastCustomNonConfigurationInstance() {
        Object o = delegate.getLastCustomNonConfigurationInstance();
        return o == null ? super.getLastCustomNonConfigurationInstance() : o;
    }

    @Override
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        delegate.dump(prefix, fd, writer, args);
        super.dump(prefix, fd, writer, args);
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        delegate.onAttachFragment(fragment);
        super.onAttachFragment(fragment);
    }

    @Override
    public FragmentManager getSupportFragmentManager() {
        FragmentManager manager = delegate.getSupportFragmentManager();
        return manager == null ? super.getSupportFragmentManager() : manager;
    }

    @Override
    public LoaderManager getSupportLoaderManager() {
        LoaderManager manager = delegate.getSupportLoaderManager();
        return manager == null ? super.getSupportLoaderManager() : manager;
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        delegate.startActivityForResult(intent, requestCode);
        super.startActivityForResult(intent, requestCode);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        delegate.onRequestPermissionsResult(requestCode, permissions, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void startActivityFromFragment(Fragment fragment, Intent intent, int requestCode) {
        delegate.startActivityFromFragment(fragment, intent, requestCode);
        super.startActivityFromFragment(fragment, intent, requestCode);
    }

    @Override
    public void startActivityFromFragment(Fragment fragment, Intent intent, int requestCode, @Nullable Bundle options) {
        delegate.startActivityFromFragment(fragment, intent, requestCode, options);
        super.startActivityFromFragment(fragment, intent, requestCode, options);
    }

    @Override
    public void startIntentSenderFromFragment(Fragment fragment, IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
        delegate.startIntentSenderFromFragment(fragment, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
        super.startIntentSenderFromFragment(fragment, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        View view = delegate.onCreateView(parent, name, context, attrs);
        return view == null ? super.onCreateView(parent, name, context, attrs) : view;
    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        View view = delegate.onCreateView(name, context, attrs);
        return view == null ? super.onCreateView(name, context, attrs) : view;
    }

    @Override
    public void startIntentSenderForResult(IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        delegate.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags);
        super.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags);
    }


    @Override
    public Intent getIntent() {
        Intent intent = delegate.getIntent();
        return intent == null ? super.getIntent() : intent;
    }

    @Override
    public void setIntent(Intent newIntent) {
        delegate.setIntent(newIntent);
        super.setIntent(newIntent);
    }

    @Override
    public WindowManager getWindowManager() {
        WindowManager windowManager = delegate.getWindowManager();
        return windowManager == null ? super.getWindowManager() : windowManager;
    }

    @Override
    public Window getWindow() {
        delegate.getWindow();
        return super.getWindow();
    }

    @Override
    public android.app.LoaderManager getLoaderManager() {
        delegate.getLoaderManager();
        return super.getLoaderManager();
    }

    @Nullable
    @Override
    public View getCurrentFocus() {
        delegate.getCurrentFocus();
        return super.getCurrentFocus();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        delegate.onCreate(savedInstanceState, persistentState);
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        delegate.onRestoreInstanceState(savedInstanceState, persistentState);
        super.onRestoreInstanceState(savedInstanceState, persistentState);
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        delegate.onPostCreate(savedInstanceState, persistentState);
        super.onPostCreate(savedInstanceState, persistentState);
    }

    @Override
    public boolean isVoiceInteraction() {
        delegate.isVoiceInteraction();
        return super.isVoiceInteraction();
    }

    @Override
    public boolean isVoiceInteractionRoot() {
        delegate.isVoiceInteractionRoot();
        return super.isVoiceInteractionRoot();
    }

    @Override
    public VoiceInteractor getVoiceInteractor() {
        delegate.getVoiceInteractor();
        return super.getVoiceInteractor();
    }

    @Override
    public boolean isLocalVoiceInteractionSupported() {
        delegate.isLocalVoiceInteractionSupported();
        return super.isLocalVoiceInteractionSupported();
    }

    @Override
    public void startLocalVoiceInteraction(Bundle privateOptions) {
        delegate.startLocalVoiceInteraction(privateOptions);
        super.startLocalVoiceInteraction(privateOptions);
    }

    @Override
    public void onLocalVoiceInteractionStarted() {
        delegate.onLocalVoiceInteractionStarted();
        super.onLocalVoiceInteractionStarted();
    }

    @Override
    public void onLocalVoiceInteractionStopped() {
        delegate.onLocalVoiceInteractionStopped();
        super.onLocalVoiceInteractionStopped();
    }

    @Override
    public void stopLocalVoiceInteraction() {
        delegate.stopLocalVoiceInteraction();
        super.stopLocalVoiceInteraction();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        delegate.onSaveInstanceState(outState, outPersistentState);
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    public boolean onCreateThumbnail(Bitmap outBitmap, Canvas canvas) {
        delegate.onCreateThumbnail(outBitmap, canvas);
        return super.onCreateThumbnail(outBitmap, canvas);
    }

    @Nullable
    @Override
    public CharSequence onCreateDescription() {
        delegate.onCreateDescription();
        return super.onCreateDescription();
    }

    @Override
    public void onProvideAssistData(Bundle data) {
        delegate.onProvideAssistData(data);
        super.onProvideAssistData(data);
    }

    @Override
    public void onProvideAssistContent(AssistContent outContent) {
        delegate.onProvideAssistContent(outContent);
        super.onProvideAssistContent(outContent);
    }

    @Override
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> data, Menu menu, int deviceId) {
        delegate.onProvideKeyboardShortcuts(data, menu, deviceId);
        super.onProvideKeyboardShortcuts(data, menu, deviceId);
    }

    @Override
    public boolean showAssist(Bundle args) {
        delegate.showAssist(args);
        return super.showAssist(args);
    }

    @Override
    public void reportFullyDrawn() {
        delegate.reportFullyDrawn();
        super.reportFullyDrawn();
    }

    @Override
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode, Configuration newConfig) {
        delegate.onMultiWindowModeChanged(isInMultiWindowMode, newConfig);
        super.onMultiWindowModeChanged(isInMultiWindowMode, newConfig);
    }

    @Override
    public boolean isInMultiWindowMode() {
        delegate.isInMultiWindowMode();
        return super.isInMultiWindowMode();
    }

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode, Configuration newConfig) {
        delegate.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig);
        super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig);
    }

    @Override
    public boolean isInPictureInPictureMode() {
        delegate.isInPictureInPictureMode();
        return super.isInPictureInPictureMode();
    }

    @Override
    public void enterPictureInPictureMode() {
        delegate.enterPictureInPictureMode();
        super.enterPictureInPictureMode();
    }

    @Override
    public boolean enterPictureInPictureMode(@NonNull PictureInPictureParams params) {
        delegate.enterPictureInPictureMode(params);
        return super.enterPictureInPictureMode(params);
    }

    @Override
    public void setPictureInPictureParams(@NonNull PictureInPictureParams params) {
        delegate.setPictureInPictureParams(params);
        super.setPictureInPictureParams(params);
    }

    @Override
    public int getMaxNumPictureInPictureActions() {
        Integer integer = delegate.getMaxNumPictureInPictureActions();
        return integer == null ? super.getMaxNumPictureInPictureActions() : integer;
    }

    @Override
    public int getChangingConfigurations() {
        Integer integer = delegate.getChangingConfigurations();
        return integer == null ? super.getChangingConfigurations() : integer;
    }

    @Nullable
    @Override
    public Object getLastNonConfigurationInstance() {
        Object o = delegate.getLastNonConfigurationInstance();
        return o == null ? super.getLastNonConfigurationInstance() : o;
    }

    @Override
    public void onTrimMemory(int level) {
        delegate.onTrimMemory(level);
        super.onTrimMemory(level);
    }

    @Override
    public android.app.FragmentManager getFragmentManager() {
        android.app.FragmentManager manager = delegate.getFragmentManager();
        return manager == null ? super.getFragmentManager() : manager;
    }

    @Override
    public void onAttachFragment(android.app.Fragment fragment) {
        delegate.onAttachFragment(fragment);
        super.onAttachFragment(fragment);
    }


    @Nullable
    @Override
    public android.app.ActionBar getActionBar() {
        android.app.ActionBar actionBar = delegate.getActionBar();
        return actionBar == null ? super.getActionBar() : actionBar;
    }

    @Override
    public void setActionBar(@Nullable android.widget.Toolbar toolbar) {
        delegate.setActionBar(toolbar);
        super.setActionBar(toolbar);
    }

    @Override
    public TransitionManager getContentTransitionManager() {
        TransitionManager manager = delegate.getContentTransitionManager();
        return manager == null ? super.getContentTransitionManager() : manager;
    }

    @Override
    public void setContentTransitionManager(TransitionManager tm) {
        delegate.setContentTransitionManager(tm);
        super.setContentTransitionManager(tm);
    }

    @Override
    public Scene getContentScene() {
        Scene scene = delegate.getContentScene();
        return scene == null ? super.getContentScene() : scene;
    }

    @Override
    public void setFinishOnTouchOutside(boolean finish) {
        delegate.setFinishOnTouchOutside(finish);
        super.setFinishOnTouchOutside(finish);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        Boolean aBoolean = delegate.onKeyLongPress(keyCode, event);
        return aBoolean == null ? super.onKeyLongPress(keyCode, event) : aBoolean;
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Boolean aBoolean = delegate.onKeyUp(keyCode, event);
        return aBoolean == null ? super.onKeyUp(keyCode, event) : aBoolean;
    }

    @Override
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        Boolean aBoolean = delegate.onKeyMultiple(keyCode, repeatCount, event);
        return aBoolean == null ? super.onKeyMultiple(keyCode, repeatCount, event) : aBoolean;
    }

    @Override
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        Boolean aBoolean = delegate.onKeyShortcut(keyCode, event);
        return aBoolean == null ? super.onKeyShortcut(keyCode, event) : aBoolean;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Boolean aBoolean = delegate.onTouchEvent(event);
        return aBoolean == null ? super.onTouchEvent(event) : aBoolean;
    }

    @Override
    public boolean onTrackballEvent(MotionEvent event) {
        Boolean aBoolean = delegate.onTrackballEvent(event);
        return aBoolean == null ? super.onTrackballEvent(event) : aBoolean;
    }

    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        Boolean aBoolean = delegate.onGenericMotionEvent(event);
        return aBoolean == null ? super.onGenericMotionEvent(event) : aBoolean;
    }

    @Override
    public void onUserInteraction() {
        delegate.onUserInteraction();
        super.onUserInteraction();
    }

    @Override
    public void onWindowAttributesChanged(WindowManager.LayoutParams params) {
        delegate.onWindowAttributesChanged(params);
        super.onWindowAttributesChanged(params);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        delegate.onWindowFocusChanged(hasFocus);
        super.onWindowFocusChanged(hasFocus);
    }

    @Override
    public void onAttachedToWindow() {
        delegate.onAttachedToWindow();
        super.onAttachedToWindow();
    }

    @Override
    public void onDetachedFromWindow() {
        delegate.onDetachedFromWindow();
        super.onDetachedFromWindow();
    }

    @Override
    public boolean hasWindowFocus() {
        Boolean aBoolean = delegate.hasWindowFocus();
        return aBoolean == null ? super.hasWindowFocus() : aBoolean;
    }

    @Override
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        Boolean aBoolean = delegate.dispatchKeyShortcutEvent(event);
        return aBoolean == null ? super.dispatchKeyShortcutEvent(event) : aBoolean;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Boolean aBoolean = delegate.dispatchTouchEvent(ev);
        return aBoolean == null ? super.dispatchTouchEvent(ev) : aBoolean;
    }

    @Override
    public boolean dispatchTrackballEvent(MotionEvent ev) {
        Boolean aBoolean = delegate.dispatchTrackballEvent(ev);
        return aBoolean == null ? super.dispatchTrackballEvent(ev) : aBoolean;
    }

    @Override
    public boolean dispatchGenericMotionEvent(MotionEvent ev) {
        Boolean aBoolean = delegate.dispatchGenericMotionEvent(ev);
        return aBoolean == null ? super.dispatchGenericMotionEvent(ev) : aBoolean;
    }

    @Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        Boolean aBoolean = delegate.dispatchPopulateAccessibilityEvent(event);
        return aBoolean == null ? super.dispatchPopulateAccessibilityEvent(event) : aBoolean;
    }

    @Nullable
    @Override
    public View onCreatePanelView(int featureId) {
        View view = delegate.onCreatePanelView(featureId);
        return view == null ? super.onCreatePanelView(featureId) : view;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Boolean aBoolean = delegate.onCreateOptionsMenu(menu);
        return aBoolean == null ? super.onCreateOptionsMenu(menu) : aBoolean;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        Boolean aBoolean = delegate.onPrepareOptionsMenu(menu);
        return aBoolean == null ? super.onPrepareOptionsMenu(menu) : aBoolean;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Boolean aBoolean = delegate.onOptionsItemSelected(item);
        return aBoolean == null ? super.onOptionsItemSelected(item) : aBoolean;
    }

    @Override
    public boolean onNavigateUp() {
        Boolean aBoolean = delegate.onNavigateUp();
        return aBoolean == null ? super.onNavigateUp() : aBoolean;
    }

    @Override
    public boolean onNavigateUpFromChild(Activity child) {
        Boolean aBoolean = delegate.onNavigateUpFromChild(child);
        return aBoolean == null ? super.onNavigateUpFromChild(child) : aBoolean;
    }

    @Override
    public void onCreateNavigateUpTaskStack(android.app.TaskStackBuilder builder) {
        delegate.onCreateNavigateUpTaskStack(builder);
        super.onCreateNavigateUpTaskStack(builder);
    }

    @Override
    public void onPrepareNavigateUpTaskStack(android.app.TaskStackBuilder builder) {
        delegate.onPrepareNavigateUpTaskStack(builder);
        super.onPrepareNavigateUpTaskStack(builder);
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        delegate.onOptionsMenuClosed(menu);
        super.onOptionsMenuClosed(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        delegate.onCreateContextMenu(menu, v, menuInfo);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public void registerForContextMenu(View view) {
        delegate.registerForContextMenu(view);
        super.registerForContextMenu(view);
    }

    @Override
    public void unregisterForContextMenu(View view) {
        delegate.unregisterForContextMenu(view);
        super.unregisterForContextMenu(view);
    }

    @Override
    public void openContextMenu(View view) {
        delegate.openContextMenu(view);
        super.openContextMenu(view);
    }

    @Override
    public void closeContextMenu() {
        delegate.closeContextMenu();
        super.closeContextMenu();
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Boolean aBoolean = delegate.onContextItemSelected(item);
        return aBoolean == null ? super.onContextItemSelected(item) : aBoolean;
    }

    @Override
    public void onContextMenuClosed(Menu menu) {
        delegate.onContextMenuClosed(menu);
        super.onContextMenuClosed(menu);
    }


    @Override
    public boolean onSearchRequested(@Nullable SearchEvent searchEvent) {
        Boolean aBoolean = delegate.onSearchRequested(searchEvent);
        return aBoolean == null ? super.onSearchRequested(searchEvent) : aBoolean;
    }

    @Override
    public boolean onSearchRequested() {
        Boolean aBoolean = delegate.onSearchRequested();
        return aBoolean == null ? super.onSearchRequested() : aBoolean;
    }

    @Override
    public void startSearch(@Nullable String initialQuery, boolean selectInitialQuery, @Nullable Bundle appSearchData, boolean globalSearch) {
        delegate.startSearch(initialQuery, selectInitialQuery, appSearchData, globalSearch);
        super.startSearch(initialQuery, selectInitialQuery, appSearchData, globalSearch);
    }

    @Override
    public void triggerSearch(String query, @Nullable Bundle appSearchData) {
        delegate.triggerSearch(query, appSearchData);
        super.triggerSearch(query, appSearchData);
    }

    @Override
    public void takeKeyEvents(boolean get) {
        delegate.takeKeyEvents(get);
        super.takeKeyEvents(get);
    }

    @NonNull
    @Override
    public LayoutInflater getLayoutInflater() {
        LayoutInflater inflater = delegate.getLayoutInflater();
        return inflater == null ? super.getLayoutInflater() : inflater;
    }

    @Override
    public boolean shouldShowRequestPermissionRationale(@NonNull String permission) {
        Boolean aBoolean = delegate.shouldShowRequestPermissionRationale(permission);
        return aBoolean == null ? super.shouldShowRequestPermissionRationale(permission) : aBoolean;
    }

    @Override
    public boolean isActivityTransitionRunning() {
        Boolean aBoolean = delegate.isActivityTransitionRunning();
        return aBoolean == null ? super.isActivityTransitionRunning() : aBoolean;
    }

    @Override
    public void startActivity(Intent intent) {
        delegate.startActivity(intent);
        super.startActivity(intent);
    }

    @Override
    public void startActivity(Intent intent, @Nullable Bundle options) {
        delegate.startActivity(intent, options);
        super.startActivity(intent, options);
    }

    @Override
    public void startActivities(Intent[] intents) {
        delegate.startActivities(intents);
        super.startActivities(intents);
    }

    @Override
    public void startActivities(Intent[] intents, @Nullable Bundle options) {
        delegate.startActivities(intents, options);
        super.startActivities(intents, options);
    }

    @Override
    public void startIntentSender(IntentSender intent, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        delegate.startIntentSender(intent, fillInIntent, flagsMask, flagsValues, extraFlags);
        super.startIntentSender(intent, fillInIntent, flagsMask, flagsValues, extraFlags);
    }

    @Override
    public void startIntentSender(IntentSender intent, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
        delegate.startIntentSender(intent, fillInIntent, flagsMask, flagsValues, extraFlags, options);
        super.startIntentSender(intent, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }

    @Override
    public boolean startActivityIfNeeded(@NonNull Intent intent, int requestCode) {
        Boolean aBoolean = delegate.startActivityIfNeeded(intent, requestCode);
        return aBoolean == null ? super.startActivityIfNeeded(intent, requestCode) : aBoolean;
    }

    @Override
    public boolean startActivityIfNeeded(@NonNull Intent intent, int requestCode, @Nullable Bundle options) {
        Boolean aBoolean = delegate.startActivityIfNeeded(intent, requestCode, options);
        return aBoolean == null ? super.startActivityIfNeeded(intent, requestCode, options) : aBoolean;
    }

    @Override
    public boolean startNextMatchingActivity(@NonNull Intent intent) {
        Boolean aBoolean = delegate.startNextMatchingActivity(intent);
        return aBoolean == null ? super.startNextMatchingActivity(intent) : aBoolean;
    }

    @Override
    public boolean startNextMatchingActivity(@NonNull Intent intent, @Nullable Bundle options) {
        Boolean aBoolean = delegate.startNextMatchingActivity(intent, options);
        return aBoolean == null ? super.startNextMatchingActivity(intent, options) : aBoolean;
    }

    @Override
    public void startActivityFromChild(@NonNull Activity child, Intent intent, int requestCode) {
        delegate.startActivityFromChild(child, intent, requestCode);
        super.startActivityFromChild(child, intent, requestCode);
    }

    @Override
    public void startActivityFromChild(@NonNull Activity child, Intent intent, int requestCode, @Nullable Bundle options) {
        delegate.startActivityFromChild(child, intent, requestCode, options);
        super.startActivityFromChild(child, intent, requestCode, options);
    }

    @Override
    public void startActivityFromFragment(@NonNull android.app.Fragment fragment, Intent intent, int requestCode) {
        delegate.startActivityFromFragment(fragment, intent, requestCode);
        super.startActivityFromFragment(fragment, intent, requestCode);
    }

    @Override
    public void startActivityFromFragment(@NonNull android.app.Fragment fragment, Intent intent, int requestCode, @Nullable Bundle options) {
        delegate.startActivityFromFragment(fragment, intent, requestCode, options);
        super.startActivityFromFragment(fragment, intent, requestCode, options);
    }

    @Override
    public void startIntentSenderFromChild(Activity child, IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        delegate.startIntentSenderFromChild(child, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags);
        super.startIntentSenderFromChild(child, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags);
    }

    @Override
    public void startIntentSenderFromChild(Activity child, IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, @Nullable Bundle options) throws IntentSender.SendIntentException {
        delegate.startIntentSenderFromChild(child, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
        super.startIntentSenderFromChild(child, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }

    @Override
    public void overridePendingTransition(int enterAnim, int exitAnim) {
        delegate.overridePendingTransition(enterAnim, exitAnim);
        super.overridePendingTransition(enterAnim, exitAnim);
    }

    @Nullable
    @Override
    public Uri getReferrer() {
        Uri uri = delegate.getReferrer();
        return uri == null ? super.getReferrer() : uri;
    }

    @Override
    public Uri onProvideReferrer() {
        Uri uri = delegate.onProvideReferrer();
        return uri == null ? super.onProvideReferrer() : uri;
    }

    @Nullable
    @Override
    public String getCallingPackage() {
        String s = delegate.getCallingPackage();
        return s == null ? super.getCallingPackage() : s;
    }

    @Nullable
    @Override
    public ComponentName getCallingActivity() {
        ComponentName name = delegate.getCallingActivity();
        return name == null ? super.getCallingActivity() : name;
    }

    @Override
    public void setVisible(boolean visible) {
        delegate.setVisible(visible);
        super.setVisible(visible);
    }

    @Override
    public boolean isFinishing() {
        Boolean aBoolean = delegate.isFinishing();
        return aBoolean == null ? super.isFinishing() : aBoolean;
    }

    @Override
    public boolean isDestroyed() {
        Boolean aBoolean = delegate.isDestroyed();
        return aBoolean == null ? super.isDestroyed() : aBoolean;
    }

    @Override
    public boolean isChangingConfigurations() {
        Boolean aBoolean = delegate.isChangingConfigurations();
        return aBoolean == null ? super.isChangingConfigurations() : aBoolean;
    }

    @Override
    public void recreate() {
        delegate.recreate();
        super.recreate();
    }

    @Override
    public void finish() {
        delegate.finish();
        super.finish();
    }

    @Override
    public void finishAffinity() {
        delegate.finishAffinity();
        super.finishAffinity();
    }

    @Override
    public void finishFromChild(Activity child) {
        delegate.finishFromChild(child);
        super.finishFromChild(child);
    }

    @Override
    public void finishAfterTransition() {
        delegate.finishAfterTransition();
        super.finishAfterTransition();
    }

    @Override
    public void finishActivity(int requestCode) {
        delegate.finishActivity(requestCode);
        super.finishActivity(requestCode);
    }

    @Override
    public void finishActivityFromChild(@NonNull Activity child, int requestCode) {
        delegate.finishActivityFromChild(child, requestCode);
        super.finishActivityFromChild(child, requestCode);
    }

    @Override
    public void finishAndRemoveTask() {
        delegate.finishAndRemoveTask();
        super.finishAndRemoveTask();
    }

    @Override
    public boolean releaseInstance() {
        Boolean aBoolean = delegate.releaseInstance();
        return aBoolean == null ? super.releaseInstance() : aBoolean;
    }

    @Override
    public void onActivityReenter(int resultCode, Intent data) {
        delegate.onActivityReenter(resultCode, data);
        super.onActivityReenter(resultCode, data);
    }

    @Override
    public PendingIntent createPendingResult(int requestCode, @NonNull Intent data, int flags) {
        PendingIntent pendingIntent = delegate.createPendingResult(requestCode, data, flags);
        return pendingIntent == null ? super.createPendingResult(requestCode, data, flags) : pendingIntent;
    }

    @Override
    public void setRequestedOrientation(int requestedOrientation) {
        delegate.setRequestedOrientation(requestedOrientation);
        super.setRequestedOrientation(requestedOrientation);
    }

    @Override
    public int getRequestedOrientation() {
        Integer integer = delegate.getRequestedOrientation();
        return integer == null ? super.getRequestedOrientation() : integer;
    }

    @Override
    public int getTaskId() {
        Integer integer = delegate.getTaskId();
        return integer == null ? super.getTaskId() : integer;
    }

    @Override
    public boolean isTaskRoot() {
        Boolean aBoolean = delegate.isTaskRoot();
        return aBoolean == null ? super.isTaskRoot() : aBoolean;
    }

    @Override
    public boolean moveTaskToBack(boolean nonRoot) {
        Boolean aBoolean = delegate.moveTaskToBack(nonRoot);
        return aBoolean == null ? super.moveTaskToBack(nonRoot) : aBoolean;
    }

    @NonNull
    @Override
    public String getLocalClassName() {
        String s = delegate.getLocalClassName();
        return s == null ? super.getLocalClassName() : s;
    }

    @Override
    public ComponentName getComponentName() {
        ComponentName name = delegate.getComponentName();
        return name == null ? super.getComponentName() : name;
    }

    @Override
    public SharedPreferences getPreferences(int mode) {
        SharedPreferences preferences = delegate.getPreferences(mode);
        return preferences == null ? super.getPreferences(mode) : preferences;
    }

    @Override
    public Object getSystemService(@NonNull String name) {
        Object o = delegate.getSystemService(name);
        return o == null ? super.getSystemService(name) : o;
    }

    @Override
    public void setTitle(CharSequence title) {
        delegate.setTitle(title);
        super.setTitle(title);
    }

    @Override
    public void setTitle(int titleId) {
        delegate.setTitle(titleId);
        super.setTitle(titleId);
    }

    @Override
    public void setTitleColor(int textColor) {
        delegate.setTitleColor(textColor);
        super.setTitleColor(textColor);
    }

    @Override
    public void setTaskDescription(ActivityManager.TaskDescription taskDescription) {
        delegate.setTaskDescription(taskDescription);
        super.setTaskDescription(taskDescription);
    }

    @Override
    public boolean isImmersive() {
        Boolean aBoolean = delegate.isImmersive();
        return aBoolean == null ? super.isImmersive() : aBoolean;
    }

    @Override
    public boolean requestVisibleBehind(boolean visible) {
        Boolean aBoolean = delegate.requestVisibleBehind(visible);
        return aBoolean == null ? super.requestVisibleBehind(visible) : aBoolean;
    }

    @Override
    public void onVisibleBehindCanceled() {
        delegate.onVisibleBehindCanceled();
        super.onVisibleBehindCanceled();
    }

    @Override
    public void onEnterAnimationComplete() {
        delegate.onEnterAnimationComplete();
        super.onEnterAnimationComplete();
    }

    @Override
    public void setImmersive(boolean i) {
        delegate.setImmersive(i);
        super.setImmersive(i);
    }

    @Override
    public void setVrModeEnabled(boolean enabled, @NonNull ComponentName requestedComponent) throws PackageManager.NameNotFoundException {
        delegate.setVrModeEnabled(enabled, requestedComponent);
        super.setVrModeEnabled(enabled, requestedComponent);
    }

    @Nullable
    @Override
    public android.view.ActionMode startActionMode(android.view.ActionMode.Callback callback) {
        android.view.ActionMode actionMode = delegate.startActionMode(callback);
        return actionMode == null ? super.startActionMode(callback) : actionMode;
    }

    @Nullable
    @Override
    public android.view.ActionMode startActionMode(android.view.ActionMode.Callback callback, int type) {
        android.view.ActionMode actionMode = delegate.startActionMode(callback, type);
        return actionMode == null ? super.startActionMode(callback, type) : actionMode;
    }

    @Nullable
    @Override
    public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback) {
        android.view.ActionMode actionMode = delegate.onWindowStartingActionMode(callback);
        return actionMode == null ? super.onWindowStartingActionMode(callback) : actionMode;
    }

    @Nullable
    @Override
    public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback, int type) {
        android.view.ActionMode actionMode = delegate.onWindowStartingActionMode(callback, type);
        return actionMode == null ? super.onWindowStartingActionMode(callback, type) : actionMode;
    }

    @Override
    public void onActionModeStarted(android.view.ActionMode mode) {
        delegate.onActionModeStarted(mode);
        super.onActionModeStarted(mode);
    }

    @Override
    public void onActionModeFinished(android.view.ActionMode mode) {
        delegate.onActionModeFinished(mode);
        super.onActionModeFinished(mode);
    }

    @Override
    public boolean shouldUpRecreateTask(Intent targetIntent) {
        Boolean aBoolean = delegate.shouldUpRecreateTask(targetIntent);
        return aBoolean == null ? super.shouldUpRecreateTask(targetIntent) : aBoolean;
    }

    @Override
    public boolean navigateUpTo(Intent upIntent) {
        Boolean aBoolean = delegate.navigateUpTo(upIntent);
        return aBoolean == null ? super.navigateUpTo(upIntent) : aBoolean;
    }

    @Override
    public boolean navigateUpToFromChild(Activity child, Intent upIntent) {
        Boolean aBoolean = delegate.navigateUpToFromChild(child, upIntent);
        return aBoolean == null ? super.navigateUpToFromChild(child, upIntent) : aBoolean;
    }

    @Nullable
    @Override
    public Intent getParentActivityIntent() {
        Intent intent = delegate.getParentActivityIntent();
        return intent == null ? super.getParentActivityIntent() : intent;
    }

    @Override
    public void setEnterSharedElementCallback(android.app.SharedElementCallback callback) {
        delegate.setEnterSharedElementCallback(callback);
        super.setEnterSharedElementCallback(callback);
    }

    @Override
    public void setExitSharedElementCallback(android.app.SharedElementCallback callback) {
        delegate.setExitSharedElementCallback(callback);
        super.setExitSharedElementCallback(callback);
    }

    @Override
    public void postponeEnterTransition() {
        delegate.postponeEnterTransition();
        super.postponeEnterTransition();
    }

    @Override
    public void startPostponedEnterTransition() {
        delegate.startPostponedEnterTransition();
        super.startPostponedEnterTransition();
    }

    @Override
    public DragAndDropPermissions requestDragAndDropPermissions(DragEvent event) {
        DragAndDropPermissions dragAndDropPermission = delegate.requestDragAndDropPermissions(event);
        return dragAndDropPermission == null ? super.requestDragAndDropPermissions(event) : dragAndDropPermission;
    }

    @Override
    public void startLockTask() {
        delegate.startLockTask();
        super.startLockTask();
    }

    @Override
    public void stopLockTask() {
        delegate.stopLockTask();
        super.stopLockTask();
    }

    @Override
    public void showLockTaskEscapeMessage() {
        delegate.showLockTaskEscapeMessage();
        super.showLockTaskEscapeMessage();
    }

    @Override
    public void applyOverrideConfiguration(Configuration overrideConfiguration) {
        delegate.applyOverrideConfiguration(overrideConfiguration);
        super.applyOverrideConfiguration(overrideConfiguration);
    }

    @Override
    public AssetManager getAssets() {
        AssetManager assetManager = delegate.getAssets();
        return assetManager == null ? super.getAssets() : assetManager;
    }

    @Override
    public Resources.Theme getTheme() {
        Resources.Theme theme = delegate.getTheme();
        return theme == null ? super.getTheme() : theme;
    }

    @Override
    public Context getBaseContext() {
        Context context = delegate.getBaseContext();
        return context == null ? super.getBaseContext() : context;
    }

    @Override
    public PackageManager getPackageManager() {
        PackageManager packageManager = delegate.getPackageManager();
        return packageManager == null ? super.getPackageManager() : packageManager;
    }

    @Override
    public ContentResolver getContentResolver() {
        ContentResolver contentResolver = delegate.getContentResolver();
        return contentResolver == null ? super.getContentResolver() : contentResolver;
    }

    @Override
    public Looper getMainLooper() {
        Looper looper = delegate.getMainLooper();
        return looper == null ? super.getMainLooper() : looper;
    }

    @Override
    public Context getApplicationContext() {
        Context context = delegate.getApplicationContext();
        return context == null ? super.getApplicationContext() : context;
    }

    @Override
    public ClassLoader getClassLoader() {
        ClassLoader classLoader = delegate.getClassLoader();
        return classLoader == null ? super.getClassLoader() : classLoader;
    }

    @Override
    public String getPackageName() {
        String s = delegate.getPackageName();
        return s == null ? super.getPackageName() : s;
    }

    @Override
    public ApplicationInfo getApplicationInfo() {
        ApplicationInfo applicationInfo = delegate.getApplicationInfo();
        return applicationInfo == null ? super.getApplicationInfo() : applicationInfo;
    }

    @Override
    public String getPackageResourcePath() {
        String s = delegate.getPackageResourcePath();
        return s == null ? super.getPackageResourcePath() : s;
    }

    @Override
    public String getPackageCodePath() {
        String s = delegate.getPackageCodePath();
        return s == null ? super.getPackageCodePath() : s;
    }

    @Override
    public SharedPreferences getSharedPreferences(String name, int mode) {
        SharedPreferences preferences = delegate.getSharedPreferences(name, mode);
        return preferences == null ? super.getSharedPreferences(name, mode) : preferences;
    }

    @Override
    public boolean moveSharedPreferencesFrom(Context sourceContext, String name) {
        Boolean aBoolean = delegate.moveSharedPreferencesFrom(sourceContext, name);
        return aBoolean == null ? super.moveSharedPreferencesFrom(sourceContext, name) : aBoolean;
    }

    @Override
    public boolean deleteSharedPreferences(String name) {
        Boolean aBoolean = delegate.deleteSharedPreferences(name);
        return aBoolean == null ? super.deleteSharedPreferences(name) : aBoolean;
    }

    @Override
    public FileInputStream openFileInput(String name) throws FileNotFoundException {
        FileInputStream stream = delegate.openFileInput(name);
        return stream == null ? super.openFileInput(name) : stream;
    }

    @Override
    public FileOutputStream openFileOutput(String name, int mode) throws FileNotFoundException {
        FileOutputStream stream = delegate.openFileOutput(name, mode);
        return stream == null ? super.openFileOutput(name, mode) : stream;
    }

    @Override
    public boolean deleteFile(String name) {
        Boolean aBoolean = delegate.deleteFile(name);
        return aBoolean == null ? super.deleteFile(name) : aBoolean;
    }

    @Override
    public File getFileStreamPath(String name) {
        File file = delegate.getFileStreamPath(name);
        return file == null ? super.getFileStreamPath(name) : file;
    }

    @Override
    public String[] fileList() {
        String[] strings = delegate.fileList();
        return strings == null ? super.fileList() : strings;
    }

    @Override
    public File getDataDir() {
        File file = delegate.getDataDir();
        return file == null ? super.getDataDir() : file;
    }

    @Override
    public File getFilesDir() {
        File file = delegate.getFilesDir();
        return file == null ? super.getFilesDir() : file;
    }

    @Override
    public File getNoBackupFilesDir() {
        File file = delegate.getNoBackupFilesDir();
        return file == null ? super.getNoBackupFilesDir() : file;
    }

    @Override
    public File getExternalFilesDir(String type) {
        File file = delegate.getExternalFilesDir(type);
        return file == null ? super.getExternalFilesDir(type) : file;
    }

    @Override
    public File[] getExternalFilesDirs(String type) {
        File[] files = delegate.getExternalFilesDirs(type);
        return files == null ? super.getExternalFilesDirs(type) : files;
    }

    @Override
    public File getObbDir() {
        File file = delegate.getObbDir();
        return file == null ? super.getObbDir() : file;
    }

    @Override
    public File[] getObbDirs() {
        File[] files = delegate.getObbDirs();
        return files == null ? super.getObbDirs() : files;
    }

    @Override
    public File getCacheDir() {
        File file = delegate.getCacheDir();
        return file == null ? super.getCacheDir() : file;
    }

    @Override
    public File getCodeCacheDir() {
        File file = delegate.getCodeCacheDir();
        return file == null ? super.getCodeCacheDir() : file;
    }

    @Override
    public File getExternalCacheDir() {
        File file = delegate.getExternalCacheDir();
        return file == null ? super.getExternalCacheDir() : file;
    }

    @Override
    public File[] getExternalCacheDirs() {
        File[] files = delegate.getExternalCacheDirs();
        return files == null ? super.getExternalCacheDirs() : files;
    }

    @Override
    public File[] getExternalMediaDirs() {
        File[] files = delegate.getExternalMediaDirs();
        return files == null ? super.getExternalMediaDirs() : files;
    }

    @Override
    public File getDir(String name, int mode) {
        File file = delegate.getDir(name, mode);
        return file == null ? super.getDir(name, mode) : file;
    }

    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory) {
        SQLiteDatabase database = delegate.openOrCreateDatabase(name, mode, factory);
        return database == null ? super.openOrCreateDatabase(name, mode, factory) : database;
    }

    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory, DatabaseErrorHandler errorHandler) {
        SQLiteDatabase database = delegate.openOrCreateDatabase(name, mode, factory, errorHandler);
        return database == null ? super.openOrCreateDatabase(name, mode, factory, errorHandler) : database;
    }

    @Override
    public boolean moveDatabaseFrom(Context sourceContext, String name) {
        Boolean aBoolean = delegate.moveDatabaseFrom(sourceContext, name);
        return aBoolean == null ? super.moveDatabaseFrom(sourceContext, name) : aBoolean;
    }

    @Override
    public boolean deleteDatabase(String name) {
        Boolean aBoolean = delegate.deleteDatabase(name);
        return aBoolean == null ? super.deleteDatabase(name) : aBoolean;
    }

    @Override
    public File getDatabasePath(String name) {
        File file = delegate.getDatabasePath(name);
        return file == null ? super.getDatabasePath(name) : file;
    }

    @Override
    public String[] databaseList() {
        String[] strings = delegate.fileList();
        return strings == null ? super.databaseList() : strings;
    }


    @Override
    public void sendBroadcast(Intent intent) {
        delegate.sendBroadcast(intent);
        super.sendBroadcast(intent);
    }

    @Override
    public void sendBroadcast(Intent intent, String receiverPermission) {
        delegate.sendBroadcast(intent, receiverPermission);
        super.sendBroadcast(intent, receiverPermission);
    }

    @Override
    public void sendOrderedBroadcast(Intent intent, String receiverPermission) {
        delegate.sendOrderedBroadcast(intent, receiverPermission);
        super.sendOrderedBroadcast(intent, receiverPermission);
    }

    @Override
    public void sendOrderedBroadcast(Intent intent, String receiverPermission, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {
        delegate.sendOrderedBroadcast(intent, receiverPermission, resultReceiver, scheduler, initialCode, initialData, initialExtras);
        super.sendOrderedBroadcast(intent, receiverPermission, resultReceiver, scheduler, initialCode, initialData, initialExtras);
    }


    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        Intent intent = delegate.registerReceiver(receiver, filter);
        return intent == null ? super.registerReceiver(receiver, filter) : intent;
    }

    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter, int flags) {
        Intent intent = delegate.registerReceiver(receiver, filter, flags);
        return intent == null ? super.registerReceiver(receiver, filter, flags) : intent;
    }

    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter, String broadcastPermission, Handler scheduler) {
        Intent intent = delegate.registerReceiver(receiver, filter, broadcastPermission, scheduler);
        return intent == null ? super.registerReceiver(receiver, filter, broadcastPermission, scheduler) : intent;
    }

    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter, String broadcastPermission, Handler scheduler, int flags) {
        Intent intent = delegate.registerReceiver(receiver, filter, broadcastPermission, scheduler, flags);
        return intent == null ? super.registerReceiver(receiver, filter, broadcastPermission, scheduler, flags) : intent;
    }

    @Override
    public void unregisterReceiver(BroadcastReceiver receiver) {
        delegate.unregisterReceiver(receiver);
        super.unregisterReceiver(receiver);
    }

    @Override
    public ComponentName startService(Intent service) {
        ComponentName name = delegate.startService(service);
        return name == null ? super.startService(service) : name;
    }

    @Override
    public ComponentName startForegroundService(Intent service) {
        ComponentName name = delegate.startForegroundService(service);
        return name == null ? super.startForegroundService(service) : name;
    }

    @Override
    public boolean stopService(Intent name) {
        Boolean aBoolean = delegate.stopService(name);
        return aBoolean == null ? super.stopService(name) : aBoolean;
    }

    @Override
    public boolean bindService(Intent service, ServiceConnection conn, int flags) {
        Boolean aBoolean = delegate.bindService(service, conn, flags);
        return aBoolean == null ? super.bindService(service, conn, flags) : aBoolean;
    }

    @Override
    public void unbindService(ServiceConnection conn) {
        delegate.unbindService(conn);
        super.unbindService(conn);
    }

    @Override
    public boolean startInstrumentation(ComponentName className, String profileFile, Bundle arguments) {
        Boolean aBoolean = delegate.startInstrumentation(className, profileFile, arguments);
        return aBoolean == null ? super.startInstrumentation(className, profileFile, arguments) : aBoolean;
    }

    @Override
    public String getSystemServiceName(Class<?> serviceClass) {
        String s = delegate.getSystemServiceName(serviceClass);
        return s == null ? super.getSystemServiceName(serviceClass) : s;
    }

    @Override
    public int checkPermission(String permission, int pid, int uid) {
        Integer integer = delegate.checkPermission(permission, pid, uid);
        return integer == null ? super.checkPermission(permission, pid, uid) : integer;
    }

    @Override
    public int checkCallingPermission(String permission) {
        Integer integer = delegate.checkCallingPermission(permission);
        return integer == null ? super.checkCallingPermission(permission) : integer;
    }

    @Override
    public int checkCallingOrSelfPermission(String permission) {
        Integer integer = delegate.checkCallingOrSelfPermission(permission);
        return integer == null ? super.checkCallingOrSelfPermission(permission) : integer;
    }

    @Override
    public int checkSelfPermission(String permission) {
        Integer integer = delegate.checkSelfPermission(permission);
        return integer == null ? super.checkSelfPermission(permission) : integer;
    }

    @Override
    public void enforcePermission(String permission, int pid, int uid, String message) {
        delegate.enforcePermission(permission, pid, uid, message);
        super.enforcePermission(permission, pid, uid, message);
    }

    @Override
    public void enforceCallingPermission(String permission, String message) {
        delegate.enforceCallingPermission(permission, message);
        super.enforceCallingPermission(permission, message);
    }

    @Override
    public void enforceCallingOrSelfPermission(String permission, String message) {
        delegate.enforceCallingOrSelfPermission(permission, message);
        super.enforceCallingOrSelfPermission(permission, message);
    }

    @Override
    public void grantUriPermission(String toPackage, Uri uri, int modeFlags) {
        delegate.grantUriPermission(toPackage, uri, modeFlags);
        super.grantUriPermission(toPackage, uri, modeFlags);
    }

    @Override
    public void revokeUriPermission(Uri uri, int modeFlags) {
        delegate.revokeUriPermission(uri, modeFlags);
        super.revokeUriPermission(uri, modeFlags);
    }

    @Override
    public void revokeUriPermission(String targetPackage, Uri uri, int modeFlags) {
        delegate.revokeUriPermission(targetPackage, uri, modeFlags);
        super.revokeUriPermission(targetPackage, uri, modeFlags);
    }

    @Override
    public int checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
        Integer integer = delegate.checkUriPermission(uri, pid, uid, modeFlags);
        return integer == null ? super.checkUriPermission(uri, pid, uid, modeFlags) : integer;
    }

    @Override
    public int checkCallingUriPermission(Uri uri, int modeFlags) {
        Integer integer = delegate.checkCallingUriPermission(uri, modeFlags);
        return integer == null ? super.checkCallingUriPermission(uri, modeFlags) : integer;
    }

    @Override
    public int checkCallingOrSelfUriPermission(Uri uri, int modeFlags) {
        Integer integer = delegate.checkCallingOrSelfUriPermission(uri, modeFlags);
        return integer == null ? super.checkCallingOrSelfUriPermission(uri, modeFlags) : integer;
    }

    @Override
    public int checkUriPermission(Uri uri, String readPermission, String writePermission, int pid, int uid, int modeFlags) {
        Integer integer = delegate.checkUriPermission(uri, readPermission, writePermission, pid, uid, modeFlags);
        return integer == null ? super.checkUriPermission(uri, readPermission, writePermission, pid, uid, modeFlags) : integer;
    }

    @Override
    public void enforceUriPermission(Uri uri, int pid, int uid, int modeFlags, String message) {
        delegate.enforceUriPermission(uri, pid, uid, modeFlags, message);
        super.enforceUriPermission(uri, pid, uid, modeFlags, message);
    }

    @Override
    public void enforceCallingUriPermission(Uri uri, int modeFlags, String message) {
        delegate.enforceCallingUriPermission(uri, modeFlags, message);
        super.enforceCallingUriPermission(uri, modeFlags, message);
    }

    @Override
    public void enforceCallingOrSelfUriPermission(Uri uri, int modeFlags, String message) {
        delegate.enforceCallingOrSelfUriPermission(uri, modeFlags, message);
        super.enforceCallingOrSelfUriPermission(uri, modeFlags, message);
    }

    @Override
    public void enforceUriPermission(Uri uri, String readPermission, String writePermission, int pid, int uid, int modeFlags, String message) {
        delegate.enforceUriPermission(uri, readPermission, writePermission, pid, uid, modeFlags, message);
        super.enforceUriPermission(uri, readPermission, writePermission, pid, uid, modeFlags, message);
    }

    @Override
    public Context createPackageContext(String packageName, int flags) throws PackageManager.NameNotFoundException {
        Context context = delegate.createPackageContext(packageName, flags);
        return context == null ? super.createPackageContext(packageName, flags) : context;
    }

    @Override
    public Context createConfigurationContext(Configuration overrideConfiguration) {
        Context context = delegate.createConfigurationContext(overrideConfiguration);
        return context == null ? super.createConfigurationContext(overrideConfiguration) : context;
    }

    @Override
    public Context createDisplayContext(Display display) {
        Context context = delegate.createDisplayContext(display);
        return context == null ? super.createDisplayContext(display) : context;
    }

    @Override
    public boolean isRestricted() {
        Boolean aBoolean = delegate.isRestricted();
        return aBoolean == null ? super.isRestricted() : aBoolean;
    }

    @Override
    public Context createDeviceProtectedStorageContext() {
        Context context = delegate.createDeviceProtectedStorageContext();
        return context == null ? super.createDeviceProtectedStorageContext() : context;
    }

    @Override
    public boolean isDeviceProtectedStorage() {
        Boolean aBoolean = delegate.isDeviceProtectedStorage();
        return aBoolean == null ? super.isDeviceProtectedStorage() : aBoolean;
    }

    @Override
    public Context createContextForSplit(String splitName) throws PackageManager.NameNotFoundException {
        Context context = delegate.createContextForSplit(splitName);
        return context == null ? super.createContextForSplit(splitName) : context;
    }

    @Override
    public void registerComponentCallbacks(ComponentCallbacks callback) {
        delegate.registerComponentCallbacks(callback);
        super.registerComponentCallbacks(callback);
    }

    @Override
    public void unregisterComponentCallbacks(ComponentCallbacks callback) {
        delegate.unregisterComponentCallbacks(callback);
        super.unregisterComponentCallbacks(callback);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        delegate.onPointerCaptureChanged(hasCapture);
        super.onPointerCaptureChanged(hasCapture);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        delegate.onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        delegate.onPostCreate(savedInstanceState);
        super.onPostCreate(savedInstanceState);
    }

    @Override
    public void onPostResume() {
        delegate.onPostResume();
        super.onPostResume();
    }

    @Override
    public void onStart() {
        delegate.onStart();
        super.onStart();
    }

    @Override
    public void onStop() {
        delegate.onStop();
        super.onStop();
    }

    @Override
    public void onDestroy() {
        delegate.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onTitleChanged(CharSequence title, int color) {
        delegate.onTitleChanged(title, color);
        super.onTitleChanged(title, color);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        delegate.onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        delegate.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onPause() {
        delegate.onPause();
        super.onPause();
    }

    @Override
    public void onNewIntent(Intent intent) {
        delegate.onNewIntent(intent);
        super.onNewIntent(intent);
    }

    @Override
    public void onResume() {
        delegate.onResume();
        super.onResume();
    }

    @Override
    public void onResumeFragments() {
        delegate.onResumeFragments();
        super.onResumeFragments();
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        delegate.onRestoreInstanceState(savedInstanceState);
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onRestart() {
        delegate.onRestart();
        super.onRestart();
    }

    @Override
    public void onUserLeaveHint() {
        delegate.onUserLeaveHint();
        super.onUserLeaveHint();
    }

    @Override
    public void onApplyThemeResource(Resources.Theme theme, int resid, boolean first) {
        delegate.onApplyThemeResource(theme, resid, first);
        super.onApplyThemeResource(theme, resid, first);
    }

    @Override
    public void onChildTitleChanged(Activity childActivity, CharSequence title) {
        delegate.onChildTitleChanged(childActivity, title);
        super.onChildTitleChanged(childActivity, title);
    }

    @Override
    public void attachBaseContext(Context newBase) {
        delegate.attachBaseContext(newBase);
        super.attachBaseContext(newBase);

    }

    public ActivityDelegate getComponentDelegate() {
        return new DefaultActivityDelegate();
    }

    @Override
    public void seComponentDelegate(ActivityDelegate delegate) {
        this.delegate = delegate;
    }

}
