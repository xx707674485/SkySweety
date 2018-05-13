package com.xjst.skysweety.util.delegate.component.activity;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.PendingIntent;
import android.app.PictureInPictureParams;
import android.app.assist.AssistContent;
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
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;

import com.xjst.skysweety.util.delegate.activity.ActivityDelegate;
import com.xjst.skysweety.util.delegate.component.DelegateComponent;
import com.xjst.skysweety.util.delegate.component.DelegateEmitter;
import com.xjst.skysweety.util.delegate.component.Event;
import com.xjst.skysweety.util.delegate.component.Listener;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

public class ActivityComponentDelegate implements ActivityDelegate, DelegateComponent {
    private DelegateEmitter emitter = new DelegateEmitter();


    @Override
    public <P> void addListener(Event<P> event, Listener<P> listener) {
        emitter.addListener(event, listener);
    }

    @Override
    public <P> void removeListener(Listener<P> listener) {
        emitter.removeListener(listener);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        emitter.emitEvent(Event.ON_CREATE, savedInstanceState);
    }

    @Override
    public void setTheme(int resid) {
        emitter.emitEvent(Event.SET_THEME, resid);
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        emitter.emitEvent(Event.ON_POST_CREATE, savedInstanceState);
    }

    @Nullable
    @Override
    public ActionBar getSupportActionBar() {
        emitter.emitEvent(Event.GET_SUPPORT_ACTION_BAR, null);
        return null;
    }

    @Override
    public void setSupportActionBar(@Nullable Toolbar toolbar) {
        emitter.emitEvent(Event.SET_SUPPORT_ACTION_BAR, toolbar);
    }

    @Override
    public MenuInflater getMenuInflater() {
        emitter.emitEvent(Event.GET_MENU_INFLATER, null);
        return null;
    }

    @Override
    public void setContentView(int layoutResID) {
        emitter.emitEvent(Event.SET_CONTENT_VIEW_ID, layoutResID);
    }

    @Override
    public void setContentView(View view) {

    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {

    }

    @Override
    public void addContentView(View view, ViewGroup.LayoutParams params) {

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {

    }

    @Override
    public void onPostResume() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public <T extends View> T findViewById(int id) {
        return null;
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onTitleChanged(CharSequence title, int color) {

    }

    @Override
    public Boolean supportRequestWindowFeature(int featureId) {
        return null;
    }

    @Override
    public void supportInvalidateOptionsMenu() {

    }

    @Override
    public void invalidateOptionsMenu() {

    }

    @Override
    public void onSupportActionModeStarted(@NonNull ActionMode mode) {

    }

    @Override
    public void onSupportActionModeFinished(@NonNull ActionMode mode) {

    }

    @Override
    public void onWindowStartingSupportActionMode(@NonNull ActionMode.Callback callback) {

    }

    @Override
    public ActionMode startSupportActionMode(@NonNull ActionMode.Callback callback) {
        return null;
    }

    @Override
    public void onCreateSupportNavigateUpTaskStack(@NonNull TaskStackBuilder builder) {

    }

    @Override
    public void onPrepareSupportNavigateUpTaskStack(@NonNull TaskStackBuilder builder) {

    }

    @Override
    public Boolean onSupportNavigateUp() {
        return null;
    }

    @Override
    public Intent getSupportParentActivityIntent() {
        return null;
    }

    @Override
    public Boolean supportShouldUpRecreateTask(@NonNull Intent targetIntent) {
        return null;
    }

    @Override
    public void supportNavigateUpTo(@NonNull Intent upIntent) {

    }

    @Override
    public void onContentChanged() {

    }

    @Override
    public ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        return null;
    }

    @Override
    public Boolean onMenuOpened(int featureId, Menu menu) {
        return null;
    }

    @Override
    public void onPanelClosed(int featureId, Menu menu) {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }

    @Override
    public AppCompatDelegate getDelegate() {
        return null;
    }

    @Override
    public Boolean dispatchKeyEvent(KeyEvent event) {
        return null;
    }

    @Override
    public Resources getResources() {
        return null;
    }

    @Override
    public Boolean onKeyDown(int keyCode, KeyEvent event) {
        return null;
    }

    @Override
    public void openOptionsMenu() {

    }

    @Override
    public void closeOptionsMenu() {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public void supportFinishAfterTransition() {

    }

    @Override
    public void setEnterSharedElementCallback(SharedElementCallback callback) {

    }

    @Override
    public void setExitSharedElementCallback(SharedElementCallback listener) {

    }

    @Override
    public void supportPostponeEnterTransition() {

    }

    @Override
    public void supportStartPostponedEnterTransition() {

    }

    @Override
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {

    }

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {

    }

    @Override
    public void getLifecycle() {

    }

    @Override
    public void onCreatePanelMenu(int featureId, Menu menu) {

    }

    @Override
    public void onLowMemory() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onNewIntent(Intent intent) {

    }

    @Override
    public void onStateNotSaved() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onResumeFragments() {

    }

    @Override
    public Boolean onPreparePanel(int featureId, View view, Menu menu) {
        return null;
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @Override
    public Object getLastCustomNonConfigurationInstance() {
        return null;
    }

    @Override
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {

    }

    @Override
    public void onAttachFragment(Fragment fragment) {

    }

    @Override
    public FragmentManager getSupportFragmentManager() {
        return null;
    }

    @Override
    public LoaderManager getSupportLoaderManager() {
        return null;
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

    }

    @Override
    public void startActivityFromFragment(Fragment fragment, Intent intent, int requestCode) {

    }

    @Override
    public void startActivityFromFragment(Fragment fragment, Intent intent, int requestCode, @Nullable Bundle options) {

    }

    @Override
    public void startIntentSenderFromFragment(Fragment fragment, IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {

    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        return null;
    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        return null;
    }

    @Override
    public void startIntentSenderForResult(IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {

    }

    @Override
    public Intent getIntent() {
        return null;
    }

    @Override
    public void setIntent(Intent newIntent) {

    }

    @Override
    public WindowManager getWindowManager() {
        return null;
    }

    @Override
    public void getWindow() {

    }

    @Override
    public void getLoaderManager() {

    }

    @Override
    public void getCurrentFocus() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {

    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {

    }

    @Override
    public void onRestart() {

    }

    @Override
    public void isVoiceInteraction() {

    }

    @Override
    public void isVoiceInteractionRoot() {

    }

    @Override
    public void getVoiceInteractor() {

    }

    @Override
    public void isLocalVoiceInteractionSupported() {

    }

    @Override
    public void startLocalVoiceInteraction(Bundle privateOptions) {

    }

    @Override
    public void onLocalVoiceInteractionStarted() {

    }

    @Override
    public void onLocalVoiceInteractionStopped() {

    }

    @Override
    public void stopLocalVoiceInteraction() {

    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {

    }

    @Override
    public void onUserLeaveHint() {

    }

    @Override
    public void onCreateThumbnail(Bitmap outBitmap, Canvas canvas) {

    }

    @Override
    public void onCreateDescription() {

    }

    @Override
    public void onProvideAssistData(Bundle data) {

    }

    @Override
    public void onProvideAssistContent(AssistContent outContent) {

    }

    @Override
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> data, Menu menu, int deviceId) {

    }

    @Override
    public void showAssist(Bundle args) {

    }

    @Override
    public void reportFullyDrawn() {

    }

    @Override
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode, Configuration newConfig) {

    }

    @Override
    public void isInMultiWindowMode() {

    }

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode, Configuration newConfig) {

    }

    @Override
    public void isInPictureInPictureMode() {

    }

    @Override
    public void enterPictureInPictureMode() {

    }

    @Override
    public void enterPictureInPictureMode(@NonNull PictureInPictureParams params) {

    }

    @Override
    public void setPictureInPictureParams(@NonNull PictureInPictureParams params) {

    }

    @Override
    public Integer getMaxNumPictureInPictureActions() {
        return null;
    }

    @Override
    public Integer getChangingConfigurations() {
        return null;
    }

    @Override
    public Object getLastNonConfigurationInstance() {
        return null;
    }

    @Override
    public void onTrimMemory(int level) {

    }

    @Override
    public android.app.FragmentManager getFragmentManager() {
        return null;
    }

    @Override
    public void onAttachFragment(android.app.Fragment fragment) {

    }

    @Override
    public android.app.ActionBar getActionBar() {
        return null;
    }

    @Override
    public void setActionBar(@Nullable android.widget.Toolbar toolbar) {

    }

    @Override
    public TransitionManager getContentTransitionManager() {
        return null;
    }

    @Override
    public void setContentTransitionManager(TransitionManager tm) {

    }

    @Override
    public Scene getContentScene() {
        return null;
    }

    @Override
    public void setFinishOnTouchOutside(boolean finish) {

    }

    @Override
    public Boolean onKeyLongPress(int keyCode, KeyEvent event) {
        return null;
    }

    @Override
    public Boolean onKeyUp(int keyCode, KeyEvent event) {
        return null;
    }

    @Override
    public Boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        return null;
    }

    @Override
    public Boolean onKeyShortcut(int keyCode, KeyEvent event) {
        return null;
    }

    @Override
    public Boolean onTouchEvent(MotionEvent event) {
        return null;
    }

    @Override
    public Boolean onTrackballEvent(MotionEvent event) {
        return null;
    }

    @Override
    public Boolean onGenericMotionEvent(MotionEvent event) {
        return null;
    }

    @Override
    public void onUserInteraction() {

    }

    @Override
    public void onWindowAttributesChanged(WindowManager.LayoutParams params) {

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {

    }

    @Override
    public void onAttachedToWindow() {

    }

    @Override
    public void onDetachedFromWindow() {

    }

    @Override
    public Boolean hasWindowFocus() {
        return null;
    }

    @Override
    public Boolean dispatchKeyShortcutEvent(KeyEvent event) {
        return null;
    }

    @Override
    public Boolean dispatchTouchEvent(MotionEvent ev) {
        return null;
    }

    @Override
    public Boolean dispatchTrackballEvent(MotionEvent ev) {
        return null;
    }

    @Override
    public Boolean dispatchGenericMotionEvent(MotionEvent ev) {
        return null;
    }

    @Override
    public Boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        return null;
    }

    @Override
    public View onCreatePanelView(int featureId) {
        return null;
    }

    @Override
    public Boolean onCreateOptionsMenu(Menu menu) {
        return null;
    }

    @Override
    public Boolean onPrepareOptionsMenu(Menu menu) {
        return null;
    }

    @Override
    public Boolean onOptionsItemSelected(MenuItem item) {
        return null;
    }

    @Override
    public Boolean onNavigateUp() {
        return null;
    }

    @Override
    public Boolean onNavigateUpFromChild(Activity child) {
        return null;
    }

    @Override
    public void onCreateNavigateUpTaskStack(android.app.TaskStackBuilder builder) {

    }

    @Override
    public void onPrepareNavigateUpTaskStack(android.app.TaskStackBuilder builder) {

    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

    }

    @Override
    public void registerForContextMenu(View view) {

    }

    @Override
    public void unregisterForContextMenu(View view) {

    }

    @Override
    public void openContextMenu(View view) {

    }

    @Override
    public void closeContextMenu() {

    }

    @Override
    public Boolean onContextItemSelected(MenuItem item) {
        return null;
    }

    @Override
    public void onContextMenuClosed(Menu menu) {

    }

    @Override
    public Boolean onSearchRequested(@Nullable SearchEvent searchEvent) {
        return null;
    }

    @Override
    public Boolean onSearchRequested() {
        return null;
    }

    @Override
    public void startSearch(@Nullable String initialQuery, boolean selectInitialQuery, @Nullable Bundle appSearchData, boolean globalSearch) {

    }

    @Override
    public void triggerSearch(String query, @Nullable Bundle appSearchData) {

    }

    @Override
    public void takeKeyEvents(boolean get) {

    }

    @Override
    public LayoutInflater getLayoutInflater() {
        return null;
    }

    @Override
    public void onApplyThemeResource(Resources.Theme theme, int resid, boolean first) {

    }

    @Override
    public Boolean shouldShowRequestPermissionRationale(@NonNull String permission) {
        return null;
    }

    @Override
    public Boolean isActivityTransitionRunning() {
        return null;
    }

    @Override
    public void startActivity(Intent intent) {

    }

    @Override
    public void startActivity(Intent intent, @Nullable Bundle options) {

    }

    @Override
    public void startActivities(Intent[] intents) {

    }

    @Override
    public void startActivities(Intent[] intents, @Nullable Bundle options) {

    }

    @Override
    public void startIntentSender(IntentSender intent, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {

    }

    @Override
    public void startIntentSender(IntentSender intent, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {

    }

    @Override
    public Boolean startActivityIfNeeded(@NonNull Intent intent, int requestCode) {
        return null;
    }

    @Override
    public Boolean startActivityIfNeeded(@NonNull Intent intent, int requestCode, @Nullable Bundle options) {
        return null;
    }

    @Override
    public Boolean startNextMatchingActivity(@NonNull Intent intent) {
        return null;
    }

    @Override
    public Boolean startNextMatchingActivity(@NonNull Intent intent, @Nullable Bundle options) {
        return null;
    }

    @Override
    public void startActivityFromChild(@NonNull Activity child, Intent intent, int requestCode) {

    }

    @Override
    public void startActivityFromChild(@NonNull Activity child, Intent intent, int requestCode, @Nullable Bundle options) {

    }

    @Override
    public void startActivityFromFragment(@NonNull android.app.Fragment fragment, Intent intent, int requestCode) {

    }

    @Override
    public void startActivityFromFragment(@NonNull android.app.Fragment fragment, Intent intent, int requestCode, @Nullable Bundle options) {

    }

    @Override
    public void startIntentSenderFromChild(Activity child, IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {

    }

    @Override
    public void startIntentSenderFromChild(Activity child, IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, @Nullable Bundle options) throws IntentSender.SendIntentException {

    }

    @Override
    public void overridePendingTransition(int enterAnim, int exitAnim) {

    }

    @Nullable
    @Override
    public Uri getReferrer() {
        return null;
    }

    @Override
    public Uri onProvideReferrer() {
        return null;
    }

    @Nullable
    @Override
    public String getCallingPackage() {
        return null;
    }

    @Nullable
    @Override
    public ComponentName getCallingActivity() {
        return null;
    }

    @Override
    public void setVisible(boolean visible) {

    }

    @Override
    public Boolean isFinishing() {
        return null;
    }

    @Override
    public Boolean isDestroyed() {
        return null;
    }

    @Override
    public Boolean isChangingConfigurations() {
        return null;
    }

    @Override
    public void recreate() {

    }

    @Override
    public void finish() {

    }

    @Override
    public void finishAffinity() {

    }

    @Override
    public void finishFromChild(Activity child) {

    }

    @Override
    public void finishAfterTransition() {

    }

    @Override
    public void finishActivity(int requestCode) {

    }

    @Override
    public void finishActivityFromChild(@NonNull Activity child, int requestCode) {

    }

    @Override
    public void finishAndRemoveTask() {

    }

    @Override
    public Boolean releaseInstance() {
        return null;
    }

    @Override
    public void onActivityReenter(int resultCode, Intent data) {

    }

    @Override
    public PendingIntent createPendingResult(int requestCode, @NonNull Intent data, int flags) {
        return null;
    }

    @Override
    public void setRequestedOrientation(int requestedOrientation) {

    }

    @Override
    public Integer getRequestedOrientation() {
        return null;
    }

    @Override
    public Integer getTaskId() {
        return null;
    }

    @Override
    public Boolean isTaskRoot() {
        return null;
    }

    @Override
    public Boolean moveTaskToBack(boolean nonRoot) {
        return null;
    }

    @Override
    public String getLocalClassName() {
        return null;
    }

    @Override
    public ComponentName getComponentName() {
        return null;
    }

    @Override
    public SharedPreferences getPreferences(int mode) {
        return null;
    }

    @Override
    public Object getSystemService(@NonNull String name) {
        return null;
    }

    @Override
    public void setTitle(CharSequence title) {

    }

    @Override
    public void setTitle(int titleId) {

    }

    @Override
    public void setTitleColor(int textColor) {

    }

    @Override
    public void onChildTitleChanged(Activity childActivity, CharSequence title) {

    }

    @Override
    public void setTaskDescription(ActivityManager.TaskDescription taskDescription) {

    }

    @Override
    public Boolean isImmersive() {
        return null;
    }

    @Override
    public Boolean requestVisibleBehind(boolean visible) {
        return null;
    }

    @Override
    public void onVisibleBehindCanceled() {

    }

    @Override
    public void onEnterAnimationComplete() {

    }

    @Override
    public void setImmersive(boolean i) {

    }

    @Override
    public void setVrModeEnabled(boolean enabled, @NonNull ComponentName requestedComponent) throws PackageManager.NameNotFoundException {

    }

    @Nullable
    @Override
    public android.view.ActionMode startActionMode(android.view.ActionMode.Callback callback) {
        return null;
    }

    @Nullable
    @Override
    public android.view.ActionMode startActionMode(android.view.ActionMode.Callback callback, int type) {
        return null;
    }

    @Nullable
    @Override
    public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback) {
        return null;
    }

    @Nullable
    @Override
    public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback, int type) {
        return null;
    }

    @Override
    public void onActionModeStarted(android.view.ActionMode mode) {

    }

    @Override
    public void onActionModeFinished(android.view.ActionMode mode) {

    }

    @Override
    public Boolean shouldUpRecreateTask(Intent targetIntent) {
        return null;
    }

    @Override
    public Boolean navigateUpTo(Intent upIntent) {
        return null;
    }

    @Override
    public Boolean navigateUpToFromChild(Activity child, Intent upIntent) {
        return null;
    }

    @Nullable
    @Override
    public Intent getParentActivityIntent() {
        return null;
    }

    @Override
    public void setEnterSharedElementCallback(android.app.SharedElementCallback callback) {

    }

    @Override
    public void setExitSharedElementCallback(android.app.SharedElementCallback callback) {

    }

    @Override
    public void postponeEnterTransition() {

    }

    @Override
    public void startPostponedEnterTransition() {

    }

    @Override
    public DragAndDropPermissions requestDragAndDropPermissions(DragEvent event) {
        return null;
    }

    @Override
    public void startLockTask() {

    }

    @Override
    public void stopLockTask() {

    }

    @Override
    public void showLockTaskEscapeMessage() {

    }

    @Override
    public void attachBaseContext(Context newBase) {

    }

    @Override
    public void applyOverrideConfiguration(Configuration overrideConfiguration) {

    }

    @Override
    public AssetManager getAssets() {
        return null;
    }

    @Override
    public Resources.Theme getTheme() {
        return null;
    }

    @Override
    public Context getBaseContext() {
        return null;
    }

    @Override
    public PackageManager getPackageManager() {
        return null;
    }

    @Override
    public ContentResolver getContentResolver() {
        return null;
    }

    @Override
    public Looper getMainLooper() {
        return null;
    }

    @Override
    public Context getApplicationContext() {
        return null;
    }

    @Override
    public ClassLoader getClassLoader() {
        return null;
    }

    @Override
    public String getPackageName() {
        return null;
    }

    @Override
    public ApplicationInfo getApplicationInfo() {
        return null;
    }

    @Override
    public String getPackageResourcePath() {
        return null;
    }

    @Override
    public String getPackageCodePath() {
        return null;
    }

    @Override
    public SharedPreferences getSharedPreferences(String name, int mode) {
        return null;
    }

    @Override
    public Boolean moveSharedPreferencesFrom(Context sourceContext, String name) {
        return null;
    }

    @Override
    public Boolean deleteSharedPreferences(String name) {
        return null;
    }

    @Override
    public FileInputStream openFileInput(String name) throws FileNotFoundException {
        return null;
    }

    @Override
    public FileOutputStream openFileOutput(String name, int mode) throws FileNotFoundException {
        return null;
    }

    @Override
    public Boolean deleteFile(String name) {
        return null;
    }

    @Override
    public File getFileStreamPath(String name) {
        return null;
    }

    @Override
    public String[] fileList() {
        return new String[0];
    }

    @Override
    public File getDataDir() {
        return null;
    }

    @Override
    public File getFilesDir() {
        return null;
    }

    @Override
    public File getNoBackupFilesDir() {
        return null;
    }

    @Override
    public File getExternalFilesDir(String type) {
        return null;
    }

    @Override
    public File[] getExternalFilesDirs(String type) {
        return new File[0];
    }

    @Override
    public File getObbDir() {
        return null;
    }

    @Override
    public File[] getObbDirs() {
        return new File[0];
    }

    @Override
    public File getCacheDir() {
        return null;
    }

    @Override
    public File getCodeCacheDir() {
        return null;
    }

    @Override
    public File getExternalCacheDir() {
        return null;
    }

    @Override
    public File[] getExternalCacheDirs() {
        return new File[0];
    }

    @Override
    public File[] getExternalMediaDirs() {
        return new File[0];
    }

    @Override
    public File getDir(String name, int mode) {
        return null;
    }

    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory) {
        return null;
    }

    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory, DatabaseErrorHandler errorHandler) {
        return null;
    }

    @Override
    public Boolean moveDatabaseFrom(Context sourceContext, String name) {
        return null;
    }

    @Override
    public Boolean deleteDatabase(String name) {
        return null;
    }

    @Override
    public File getDatabasePath(String name) {
        return null;
    }

    @Override
    public String[] databaseList() {
        return new String[0];
    }

    @Override
    public void sendBroadcast(Intent intent) {

    }

    @Override
    public void sendBroadcast(Intent intent, String receiverPermission) {

    }

    @Override
    public void sendOrderedBroadcast(Intent intent, String receiverPermission) {

    }

    @Override
    public void sendOrderedBroadcast(Intent intent, String receiverPermission, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {

    }

    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        return null;
    }

    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter, int flags) {
        return null;
    }

    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter, String broadcastPermission, Handler scheduler) {
        return null;
    }

    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter, String broadcastPermission, Handler scheduler, int flags) {
        return null;
    }

    @Override
    public void unregisterReceiver(BroadcastReceiver receiver) {

    }

    @Override
    public ComponentName startService(Intent service) {
        return null;
    }

    @Override
    public ComponentName startForegroundService(Intent service) {
        return null;
    }

    @Override
    public Boolean stopService(Intent name) {
        return null;
    }

    @Override
    public Boolean bindService(Intent service, ServiceConnection conn, int flags) {
        return null;
    }

    @Override
    public void unbindService(ServiceConnection conn) {

    }

    @Override
    public Boolean startInstrumentation(ComponentName className, String profileFile, Bundle arguments) {
        return null;
    }

    @Override
    public String getSystemServiceName(Class<?> serviceClass) {
        return null;
    }

    @Override
    public Integer checkPermission(String permission, int pid, int uid) {
        return null;
    }

    @Override
    public Integer checkCallingPermission(String permission) {
        return null;
    }

    @Override
    public Integer checkCallingOrSelfPermission(String permission) {
        return null;
    }

    @Override
    public Integer checkSelfPermission(String permission) {
        return null;
    }

    @Override
    public void enforcePermission(String permission, int pid, int uid, String message) {

    }

    @Override
    public void enforceCallingPermission(String permission, String message) {

    }

    @Override
    public void enforceCallingOrSelfPermission(String permission, String message) {

    }

    @Override
    public void grantUriPermission(String toPackage, Uri uri, int modeFlags) {

    }

    @Override
    public void revokeUriPermission(Uri uri, int modeFlags) {

    }

    @Override
    public void revokeUriPermission(String targetPackage, Uri uri, int modeFlags) {

    }

    @Override
    public Integer checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
        return null;
    }

    @Override
    public Integer checkCallingUriPermission(Uri uri, int modeFlags) {
        return null;
    }

    @Override
    public Integer checkCallingOrSelfUriPermission(Uri uri, int modeFlags) {
        return null;
    }

    @Override
    public Integer checkUriPermission(Uri uri, String readPermission, String writePermission, int pid, int uid, int modeFlags) {
        return null;
    }

    @Override
    public void enforceUriPermission(Uri uri, int pid, int uid, int modeFlags, String message) {

    }

    @Override
    public void enforceCallingUriPermission(Uri uri, int modeFlags, String message) {

    }

    @Override
    public void enforceCallingOrSelfUriPermission(Uri uri, int modeFlags, String message) {

    }

    @Override
    public void enforceUriPermission(Uri uri, String readPermission, String writePermission, int pid, int uid, int modeFlags, String message) {

    }

    @Override
    public Context createPackageContext(String packageName, int flags) throws PackageManager.NameNotFoundException {
        return null;
    }

    @Override
    public Context createConfigurationContext(Configuration overrideConfiguration) {
        return null;
    }

    @Override
    public Context createDisplayContext(Display display) {
        return null;
    }

    @Override
    public Boolean isRestricted() {
        return null;
    }

    @Override
    public Context createDeviceProtectedStorageContext() {
        return null;
    }

    @Override
    public Boolean isDeviceProtectedStorage() {
        return null;
    }

    @Override
    public Context createContextForSplit(String splitName) throws PackageManager.NameNotFoundException {
        return null;
    }

    @Override
    public void registerComponentCallbacks(ComponentCallbacks callback) {

    }

    @Override
    public void unregisterComponentCallbacks(ComponentCallbacks callback) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
