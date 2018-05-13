package com.xjst.skysweety.util.delegate.fragment;

import android.animation.Animator;
import android.arch.lifecycle.Lifecycle;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.SharedElementCallback;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

import com.xjst.skysweety.util.delegate.Delegate;

import java.io.FileDescriptor;
import java.io.PrintWriter;

public interface FragmentDelegate  extends Delegate{

    default void initialized(){

    }
    
    default Lifecycle getLifecycle() {
        return null;
    }

    
    default void setArguments(Bundle args) {

    }

    
    default void setInitialSavedState(Fragment.SavedState state) {

    }

    
    default void setTargetFragment(Fragment fragment, int requestCode) {

    }

    
    default Context getContext() {
        return null;
    }

    
    default void onHiddenChanged(boolean hidden) {

    }

    
    default void setRetainInstance(boolean retain) {

    }

    
    default void setHasOptionsMenu(boolean hasMenu) {

    }

    
    default void setMenuVisibility(boolean menuVisible) {

    }

    
    default void setUserVisibleHint(boolean isVisibleToUser) {

    }

    
    default Boolean getUserVisibleHint() {
        return null;
    }

    
    default LoaderManager getLoaderManager() {
        return null;
    }

    
    default void startActivity(Intent intent) {

    }

    
    default void startActivity(Intent intent, @Nullable Bundle options) {

    }

    
    default void startActivityForResult(Intent intent, int requestCode) {

    }

    
    default void startActivityForResult(Intent intent, int requestCode, @Nullable Bundle options) {

    }

    
    default void startIntentSenderForResult(IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {

    }

    
    default void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    
    default void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

    }

    
    default Boolean shouldShowRequestPermissionRationale(@NonNull String permission) {
        return null;
    }

    
    default LayoutInflater onGetLayoutInflater(Bundle savedInstanceState) {
        return null;
    }

    
    default void onInflate(Context context, AttributeSet attrs, Bundle savedInstanceState) {

    }

    
    default void onAttachFragment(Fragment childFragment) {

    }

    
    default void onAttach(Context context) {

    }

    
    default Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        return null;
    }

    
    default Animator onCreateAnimator(int transit, boolean enter, int nextAnim) {
        return null;
    }

    
    default void onCreate(@Nullable Bundle savedInstanceState) {

    }

    @Nullable
    
    default View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return null;
    }

    
    default void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

    }

    @Nullable
    
    default View getView() {
        return null;
    }

    
    default void onActivityCreated(@Nullable Bundle savedInstanceState) {

    }

    
    default void onViewStateRestored(@Nullable Bundle savedInstanceState) {

    }

    
    default void onStart() {

    }

    
    default void onResume() {

    }

    
    default void onSaveInstanceState(Bundle outState) {

    }

    
    default void onMultiWindowModeChanged(boolean isInMultiWindowMode) {

    }

    
    default void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {

    }

    
    default void onConfigurationChanged(Configuration newConfig) {

    }

    
    default void onPause() {

    }

    
    default void onStop() {

    }

    
    default void onLowMemory() {

    }

    
    default void onDestroyView() {

    }

    
    default void onDestroy() {

    }

    
    default void onDetach() {

    }

    
    default void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

    }

    
    default void onPrepareOptionsMenu(Menu menu) {

    }

    
    default void onDestroyOptionsMenu() {

    }

    
    default Boolean onOptionsItemSelected(MenuItem item) {
        return null;
    }

    
    default void onOptionsMenuClosed(Menu menu) {

    }

    
    default void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

    }

    
    default void registerForContextMenu(View view) {

    }

    
    default void unregisterForContextMenu(View view) {

    }

    
    default Boolean onContextItemSelected(MenuItem item) {
        return null;
    }

    
    default void setEnterSharedElementCallback(SharedElementCallback callback) {

    }

    
    default void setExitSharedElementCallback(SharedElementCallback callback) {

    }

    
    default void setEnterTransition(Object transition) {

    }

    
    default Object getEnterTransition() {
        return null;
    }

    
    default void setReturnTransition(Object transition) {

    }

    
    default Object getReturnTransition() {
        return null;
    }

    
    default void setExitTransition(Object transition) {

    }

    
    default Object getExitTransition() {
        return null;
    }

    
    default void setReenterTransition(Object transition) {

    }

    
    default Object getReenterTransition() {
        return null;
    }

    
    default void setSharedElementEnterTransition(Object transition) {

    }

    
    default Object getSharedElementEnterTransition() {
        return null;
    }

    
    default void setSharedElementReturnTransition(Object transition) {

    }

    
    default Object getSharedElementReturnTransition() {
        return null;
    }

    
    default void setAllowEnterTransitionOverlap(boolean allow) {

    }

    
    default Boolean getAllowEnterTransitionOverlap() {
        return null;
    }

    
    default void setAllowReturnTransitionOverlap(boolean allow) {

    }

    
    default Boolean getAllowReturnTransitionOverlap() {
        return null;
    }

    
    default void postponeEnterTransition() {

    }

    
    default void startPostponedEnterTransition() {

    }

    
    default void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {

    }

}
