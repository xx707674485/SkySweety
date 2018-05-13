package com.xjst.skysweety.util.delegate.activity;

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

import com.xjst.skysweety.util.delegate.Delegate;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

public interface ActivityDelegate extends Delegate {


    default void initialized(){

    }
    default void onCreate(@Nullable Bundle savedInstanceState) {
    }


    default void setTheme(int resid) {

    }


    default void onPostCreate(@Nullable Bundle savedInstanceState) {

    }

    @Nullable

    default ActionBar getSupportActionBar() {
        return null;
    }


    default void setSupportActionBar(@Nullable Toolbar toolbar) {

    }


    default MenuInflater getMenuInflater() {
        return null;
    }


    default void setContentView(int layoutResID) {

    }


    default void setContentView(View view) {

    }


    default void setContentView(View view, ViewGroup.LayoutParams params) {

    }


    default void addContentView(View view, ViewGroup.LayoutParams params) {

    }


    default void onConfigurationChanged(Configuration newConfig) {

    }


    default void onPostResume() {

    }


    default void onStart() {

    }


    default void onStop() {

    }


    default <T extends View> T findViewById(int id) {
        return null;
    }


    default void onDestroy() {

    }


    default void onTitleChanged(CharSequence title, int color) {

    }


    default Boolean supportRequestWindowFeature(int featureId) {
        return null;
    }


    default void supportInvalidateOptionsMenu() {

    }


    default void invalidateOptionsMenu() {

    }


    default void onSupportActionModeStarted(@NonNull ActionMode mode) {

    }


    default void onSupportActionModeFinished(@NonNull ActionMode mode) {

    }


    default void onWindowStartingSupportActionMode(@NonNull ActionMode.Callback callback) {

    }


    default ActionMode startSupportActionMode(@NonNull ActionMode.Callback callback) {
        return null;
    }


    default void onCreateSupportNavigateUpTaskStack(@NonNull TaskStackBuilder builder) {

    }


    default void onPrepareSupportNavigateUpTaskStack(@NonNull TaskStackBuilder builder) {

    }


    default Boolean onSupportNavigateUp() {
        return null;
    }


    default Intent getSupportParentActivityIntent() {
        return null;
    }


    default Boolean supportShouldUpRecreateTask(@NonNull Intent targetIntent) {
        return null;
    }


    default void supportNavigateUpTo(@NonNull Intent upIntent) {

    }


    default void onContentChanged() {

    }


    default ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        return null;
    }


    default Boolean onMenuOpened(int featureId, Menu menu) {
        return null;
    }


    default void onPanelClosed(int featureId, Menu menu) {

    }


    default void onSaveInstanceState(Bundle outState) {

    }


    default AppCompatDelegate getDelegate() {
        return null;
    }


    default Boolean dispatchKeyEvent(KeyEvent event) {
        return null;
    }


    default Resources getResources() {
        return null;
    }


    default Boolean onKeyDown(int keyCode, KeyEvent event) {
        return null;
    }


    default void openOptionsMenu() {

    }


    default void closeOptionsMenu() {

    }


    default void onActivityResult(int requestCode, int resultCode, Intent data) {

    }


    default void onBackPressed() {

    }


    default void supportFinishAfterTransition() {

    }


    default void setEnterSharedElementCallback(SharedElementCallback callback) {

    }


    default void setExitSharedElementCallback(SharedElementCallback listener) {

    }


    default void supportPostponeEnterTransition() {

    }


    default void supportStartPostponedEnterTransition() {

    }


    default void onMultiWindowModeChanged(boolean isInMultiWindowMode) {

    }


    default void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {

    }


    default void getLifecycle() {

    }


    default void onCreatePanelMenu(int featureId, Menu menu) {

    }


    default void onLowMemory() {

    }


    default void onPause() {

    }


    default void onNewIntent(Intent intent) {

    }


    default void onStateNotSaved() {

    }


    default void onResume() {

    }


    default void onResumeFragments() {

    }


    default Boolean onPreparePanel(int featureId, View view, Menu menu) {
        return null;
    }


    default Object onRetainCustomNonConfigurationInstance() {
        return null;
    }


    default Object getLastCustomNonConfigurationInstance() {
        return null;
    }


    default void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {

    }


    default void onAttachFragment(Fragment fragment) {

    }


    default FragmentManager getSupportFragmentManager() {
        return null;
    }


    default LoaderManager getSupportLoaderManager() {
        return null;
    }


    default void startActivityForResult(Intent intent, int requestCode) {

    }


    default void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

    }


    default void startActivityFromFragment(Fragment fragment, Intent intent, int requestCode) {

    }


    default void startActivityFromFragment(Fragment fragment, Intent intent, int requestCode, @Nullable Bundle options) {

    }


    default void startIntentSenderFromFragment(Fragment fragment, IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {

    }


    default View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        return null;
    }


    default View onCreateView(String name, Context context, AttributeSet attrs) {
        return null;
    }


    default void startIntentSenderForResult(IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {

    }


    default Intent getIntent() {
        return null;
    }


    default void setIntent(Intent newIntent) {

    }


    default WindowManager getWindowManager() {
        return null;
    }


    default void getWindow() {

    }


    default void getLoaderManager() {

    }


    default void getCurrentFocus() {

    }


    default void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {

    }


    default void onRestoreInstanceState(Bundle savedInstanceState) {

    }


    default void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {

    }


    default void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {

    }


    default void onRestart() {

    }


    default void isVoiceInteraction() {

    }


    default void isVoiceInteractionRoot() {

    }


    default void getVoiceInteractor() {

    }


    default void isLocalVoiceInteractionSupported() {

    }


    default void startLocalVoiceInteraction(Bundle privateOptions) {

    }


    default void onLocalVoiceInteractionStarted() {

    }


    default void onLocalVoiceInteractionStopped() {

    }


    default void stopLocalVoiceInteraction() {

    }


    default void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {

    }


    default void onUserLeaveHint() {

    }


    default void onCreateThumbnail(Bitmap outBitmap, Canvas canvas) {

    }


    default void onCreateDescription() {

    }


    default void onProvideAssistData(Bundle data) {

    }


    default void onProvideAssistContent(AssistContent outContent) {

    }


    default void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> data, Menu menu, int deviceId) {

    }


    default void showAssist(Bundle args) {

    }


    default void reportFullyDrawn() {

    }


    default void onMultiWindowModeChanged(boolean isInMultiWindowMode, Configuration newConfig) {

    }


    default void isInMultiWindowMode() {

    }


    default void onPictureInPictureModeChanged(boolean isInPictureInPictureMode, Configuration newConfig) {

    }


    default void isInPictureInPictureMode() {

    }


    default void enterPictureInPictureMode() {

    }


    default void enterPictureInPictureMode(@NonNull PictureInPictureParams params) {

    }


    default void setPictureInPictureParams(@NonNull PictureInPictureParams params) {

    }


    default Integer getMaxNumPictureInPictureActions() {
        return null;
    }


    default Integer getChangingConfigurations() {
        return null;
    }


    default Object getLastNonConfigurationInstance() {
        return null;
    }


    default void onTrimMemory(int level) {

    }


    default android.app.FragmentManager getFragmentManager() {
        return null;
    }


    default void onAttachFragment(android.app.Fragment fragment) {

    }


    default android.app.ActionBar getActionBar() {
        return null;
    }


    default void setActionBar(@Nullable android.widget.Toolbar toolbar) {

    }


    default TransitionManager getContentTransitionManager() {
        return null;
    }


    default void setContentTransitionManager(TransitionManager tm) {

    }


    default Scene getContentScene() {
        return null;
    }


    default void setFinishOnTouchOutside(boolean finish) {

    }


    default Boolean onKeyLongPress(int keyCode, KeyEvent event) {
        return null;
    }


    default Boolean onKeyUp(int keyCode, KeyEvent event) {
        return null;
    }


    default Boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        return null;
    }


    default Boolean onKeyShortcut(int keyCode, KeyEvent event) {
        return null;
    }


    default Boolean onTouchEvent(MotionEvent event) {
        return null;
    }


    default Boolean onTrackballEvent(MotionEvent event) {
        return null;
    }


    default Boolean onGenericMotionEvent(MotionEvent event) {
        return null;
    }


    default void onUserInteraction() {

    }


    default void onWindowAttributesChanged(WindowManager.LayoutParams params) {

    }


    default void onWindowFocusChanged(boolean hasFocus) {

    }


    default void onAttachedToWindow() {

    }


    default void onDetachedFromWindow() {

    }


    default Boolean hasWindowFocus() {
        return null;
    }


    default Boolean dispatchKeyShortcutEvent(KeyEvent event) {
        return null;
    }


    default Boolean dispatchTouchEvent(MotionEvent ev) {
        return null;
    }


    default Boolean dispatchTrackballEvent(MotionEvent ev) {
        return null;
    }


    default Boolean dispatchGenericMotionEvent(MotionEvent ev) {
        return null;
    }


    default Boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        return null;
    }


    default View onCreatePanelView(int featureId) {
        return null;
    }


    default Boolean onCreateOptionsMenu(Menu menu) {
        return null;
    }


    default Boolean onPrepareOptionsMenu(Menu menu) {
        return null;
    }


    default Boolean onOptionsItemSelected(MenuItem item) {
        return null;
    }


    default Boolean onNavigateUp() {
        return null;
    }


    default Boolean onNavigateUpFromChild(Activity child) {
        return null;
    }


    default void onCreateNavigateUpTaskStack(android.app.TaskStackBuilder builder) {

    }


    default void onPrepareNavigateUpTaskStack(android.app.TaskStackBuilder builder) {

    }


    default void onOptionsMenuClosed(Menu menu) {

    }


    default void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

    }


    default void registerForContextMenu(View view) {

    }


    default void unregisterForContextMenu(View view) {

    }


    default void openContextMenu(View view) {

    }


    default void closeContextMenu() {

    }


    default Boolean onContextItemSelected(MenuItem item) {
        return null;
    }


    default void onContextMenuClosed(Menu menu) {

    }


    default Boolean onSearchRequested(@Nullable SearchEvent searchEvent) {
        return null;
    }


    default Boolean onSearchRequested() {
        return null;
    }


    default void startSearch(@Nullable String initialQuery, boolean selectInitialQuery, @Nullable Bundle appSearchData, boolean globalSearch) {

    }


    default void triggerSearch(String query, @Nullable Bundle appSearchData) {

    }


    default void takeKeyEvents(boolean get) {

    }


    default LayoutInflater getLayoutInflater() {
        return null;
    }


    default void onApplyThemeResource(Resources.Theme theme, int resid, boolean first) {

    }


    default Boolean shouldShowRequestPermissionRationale(@NonNull String permission) {
        return null;
    }


    default Boolean isActivityTransitionRunning() {
        return null;
    }


    default void startActivity(Intent intent) {

    }


    default void startActivity(Intent intent, @Nullable Bundle options) {

    }


    default void startActivities(Intent[] intents) {

    }


    default void startActivities(Intent[] intents, @Nullable Bundle options) {

    }


    default void startIntentSender(IntentSender intent, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {

    }


    default void startIntentSender(IntentSender intent, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {

    }


    default Boolean startActivityIfNeeded(@NonNull Intent intent, int requestCode) {
        return null;
    }


    default Boolean startActivityIfNeeded(@NonNull Intent intent, int requestCode, @Nullable Bundle options) {
        return null;
    }


    default Boolean startNextMatchingActivity(@NonNull Intent intent) {
        return null;
    }


    default Boolean startNextMatchingActivity(@NonNull Intent intent, @Nullable Bundle options) {
        return null;
    }


    default void startActivityFromChild(@NonNull Activity child, Intent intent, int requestCode) {

    }


    default void startActivityFromChild(@NonNull Activity child, Intent intent, int requestCode, @Nullable Bundle options) {

    }


    default void startActivityFromFragment(@NonNull android.app.Fragment fragment, Intent intent, int requestCode) {

    }


    default void startActivityFromFragment(@NonNull android.app.Fragment fragment, Intent intent, int requestCode, @Nullable Bundle options) {

    }


    default void startIntentSenderFromChild(Activity child, IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {

    }


    default void startIntentSenderFromChild(Activity child, IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, @Nullable Bundle options) throws IntentSender.SendIntentException {

    }


    default void overridePendingTransition(int enterAnim, int exitAnim) {

    }

    @Nullable

    default Uri getReferrer() {
        return null;
    }


    default Uri onProvideReferrer() {
        return null;
    }

    @Nullable

    default String getCallingPackage() {
        return null;
    }

    @Nullable

    default ComponentName getCallingActivity() {
        return null;
    }


    default void setVisible(boolean visible) {

    }


    default Boolean isFinishing() {
        return null;
    }


    default Boolean isDestroyed() {
        return null;
    }


    default Boolean isChangingConfigurations() {
        return null;
    }


    default void recreate() {

    }


    default void finish() {

    }


    default void finishAffinity() {

    }


    default void finishFromChild(Activity child) {

    }


    default void finishAfterTransition() {

    }


    default void finishActivity(int requestCode) {

    }


    default void finishActivityFromChild(@NonNull Activity child, int requestCode) {

    }


    default void finishAndRemoveTask() {

    }


    default Boolean releaseInstance() {
        return null;
    }


    default void onActivityReenter(int resultCode, Intent data) {

    }


    default PendingIntent createPendingResult(int requestCode, @NonNull Intent data, int flags) {
        return null;
    }


    default void setRequestedOrientation(int requestedOrientation) {

    }


    default Integer getRequestedOrientation() {
        return null;
    }


    default Integer getTaskId() {
        return null;
    }


    default Boolean isTaskRoot() {
        return null;
    }


    default Boolean moveTaskToBack(boolean nonRoot) {
        return null;
    }


    default String getLocalClassName() {
        return null;
    }


    default ComponentName getComponentName() {
        return null;
    }


    default SharedPreferences getPreferences(int mode) {
        return null;
    }


    default Object getSystemService(@NonNull String name) {
        return null;
    }


    default void setTitle(CharSequence title) {

    }


    default void setTitle(int titleId) {

    }


    default void setTitleColor(int textColor) {

    }


    default void onChildTitleChanged(Activity childActivity, CharSequence title) {

    }


    default void setTaskDescription(ActivityManager.TaskDescription taskDescription) {

    }


    default Boolean isImmersive() {
        return null;
    }


    default Boolean requestVisibleBehind(boolean visible) {
        return null;
    }


    default void onVisibleBehindCanceled() {

    }


    default void onEnterAnimationComplete() {

    }


    default void setImmersive(boolean i) {

    }


    default void setVrModeEnabled(boolean enabled, @NonNull ComponentName requestedComponent) throws PackageManager.NameNotFoundException {

    }

    @Nullable

    default android.view.ActionMode startActionMode(android.view.ActionMode.Callback callback) {
        return null;
    }

    @Nullable

    default android.view.ActionMode startActionMode(android.view.ActionMode.Callback callback, int type) {
        return null;
    }

    @Nullable

    default android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback) {
        return null;
    }

    @Nullable

    default android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback, int type) {
        return null;
    }


    default void onActionModeStarted(android.view.ActionMode mode) {

    }


    default void onActionModeFinished(android.view.ActionMode mode) {

    }


    default Boolean shouldUpRecreateTask(Intent targetIntent) {
        return null;
    }


    default Boolean navigateUpTo(Intent upIntent) {
        return null;
    }


    default Boolean navigateUpToFromChild(Activity child, Intent upIntent) {
        return null;
    }

    @Nullable

    default Intent getParentActivityIntent() {
        return null;
    }


    default void setEnterSharedElementCallback(android.app.SharedElementCallback callback) {

    }


    default void setExitSharedElementCallback(android.app.SharedElementCallback callback) {

    }


    default void postponeEnterTransition() {

    }


    default void startPostponedEnterTransition() {

    }


    default DragAndDropPermissions requestDragAndDropPermissions(DragEvent event) {
        return null;
    }


    default void startLockTask() {

    }


    default void stopLockTask() {

    }


    default void showLockTaskEscapeMessage() {

    }


    default void attachBaseContext(Context newBase) {

    }


    default void applyOverrideConfiguration(Configuration overrideConfiguration) {

    }


    default AssetManager getAssets() {
        return null;
    }


    default Resources.Theme getTheme() {
        return null;
    }


    default Context getBaseContext() {
        return null;
    }


    default PackageManager getPackageManager() {
        return null;
    }


    default ContentResolver getContentResolver() {
        return null;
    }


    default Looper getMainLooper() {
        return null;
    }


    default Context getApplicationContext() {
        return null;
    }


    default ClassLoader getClassLoader() {
        return null;
    }


    default String getPackageName() {
        return null;
    }


    default ApplicationInfo getApplicationInfo() {
        return null;
    }


    default String getPackageResourcePath() {
        return null;
    }


    default String getPackageCodePath() {
        return null;
    }


    default SharedPreferences getSharedPreferences(String name, int mode) {
        return null;
    }


    default Boolean moveSharedPreferencesFrom(Context sourceContext, String name) {
        return null;
    }


    default Boolean deleteSharedPreferences(String name) {
        return null;
    }


    default FileInputStream openFileInput(String name) throws FileNotFoundException {
        return null;
    }


    default FileOutputStream openFileOutput(String name, int mode) throws FileNotFoundException {
        return null;
    }


    default Boolean deleteFile(String name) {
        return null;
    }


    default File getFileStreamPath(String name) {
        return null;
    }


    default String[] fileList() {
        return new String[0];
    }


    default File getDataDir() {
        return null;
    }


    default File getFilesDir() {
        return null;
    }


    default File getNoBackupFilesDir() {
        return null;
    }


    default File getExternalFilesDir(String type) {
        return null;
    }


    default File[] getExternalFilesDirs(String type) {
        return new File[0];
    }


    default File getObbDir() {
        return null;
    }


    default File[] getObbDirs() {
        return new File[0];
    }


    default File getCacheDir() {
        return null;
    }


    default File getCodeCacheDir() {
        return null;
    }


    default File getExternalCacheDir() {
        return null;
    }


    default File[] getExternalCacheDirs() {
        return new File[0];
    }


    default File[] getExternalMediaDirs() {
        return new File[0];
    }


    default File getDir(String name, int mode) {
        return null;
    }


    default SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory) {
        return null;
    }


    default SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory, DatabaseErrorHandler errorHandler) {
        return null;
    }


    default Boolean moveDatabaseFrom(Context sourceContext, String name) {
        return null;
    }


    default Boolean deleteDatabase(String name) {
        return null;
    }


    default File getDatabasePath(String name) {
        return null;
    }


    default String[] databaseList() {
        return new String[0];
    }


    default void sendBroadcast(Intent intent) {

    }


    default void sendBroadcast(Intent intent, String receiverPermission) {

    }


    default void sendOrderedBroadcast(Intent intent, String receiverPermission) {

    }


    default void sendOrderedBroadcast(Intent intent, String receiverPermission, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {

    }


    default Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        return null;
    }


    default Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter, int flags) {
        return null;
    }


    default Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter, String broadcastPermission, Handler scheduler) {
        return null;
    }


    default Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter, String broadcastPermission, Handler scheduler, int flags) {
        return null;
    }


    default void unregisterReceiver(BroadcastReceiver receiver) {

    }


    default ComponentName startService(Intent service) {
        return null;
    }


    default ComponentName startForegroundService(Intent service) {
        return null;
    }


    default Boolean stopService(Intent name) {
        return null;
    }


    default Boolean bindService(Intent service, ServiceConnection conn, int flags) {
        return null;
    }


    default void unbindService(ServiceConnection conn) {

    }


    default Boolean startInstrumentation(ComponentName className, String profileFile, Bundle arguments) {
        return null;
    }


    default String getSystemServiceName(Class<?> serviceClass) {
        return null;
    }


    default Integer checkPermission(String permission, int pid, int uid) {
        return null;
    }


    default Integer checkCallingPermission(String permission) {
        return null;
    }


    default Integer checkCallingOrSelfPermission(String permission) {
        return null;
    }


    default Integer checkSelfPermission(String permission) {
        return null;
    }


    default void enforcePermission(String permission, int pid, int uid, String message) {

    }


    default void enforceCallingPermission(String permission, String message) {

    }


    default void enforceCallingOrSelfPermission(String permission, String message) {

    }


    default void grantUriPermission(String toPackage, Uri uri, int modeFlags) {

    }


    default void revokeUriPermission(Uri uri, int modeFlags) {

    }


    default void revokeUriPermission(String targetPackage, Uri uri, int modeFlags) {

    }


    default Integer checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
        return null;
    }


    default Integer checkCallingUriPermission(Uri uri, int modeFlags) {
        return null;
    }


    default Integer checkCallingOrSelfUriPermission(Uri uri, int modeFlags) {
        return null;
    }


    default Integer checkUriPermission(Uri uri, String readPermission, String writePermission, int pid, int uid, int modeFlags) {
        return null;
    }


    default void enforceUriPermission(Uri uri, int pid, int uid, int modeFlags, String message) {

    }


    default void enforceCallingUriPermission(Uri uri, int modeFlags, String message) {

    }


    default void enforceCallingOrSelfUriPermission(Uri uri, int modeFlags, String message) {

    }


    default void enforceUriPermission(Uri uri, String readPermission, String writePermission, int pid, int uid, int modeFlags, String message) {

    }


    default Context createPackageContext(String packageName, int flags) throws PackageManager.NameNotFoundException {
        return null;
    }


    default Context createConfigurationContext(Configuration overrideConfiguration) {
        return null;
    }


    default Context createDisplayContext(Display display) {
        return null;
    }


    default Boolean isRestricted() {
        return null;
    }


    default Context createDeviceProtectedStorageContext() {
        return null;
    }


    default Boolean isDeviceProtectedStorage() {
        return null;
    }


    default Context createContextForSplit(String splitName) throws PackageManager.NameNotFoundException {
        return null;
    }


    default void registerComponentCallbacks(ComponentCallbacks callback) {

    }


    default void unregisterComponentCallbacks(ComponentCallbacks callback) {

    }


    default void onPointerCaptureChanged(boolean hasCapture) {

    }
}
        
    

