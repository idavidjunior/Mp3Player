package com.mp3player.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\u0005\u00a2\u0006\u0002\u0010\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0002R\u0012\u0010\u0003\u001a\u00060\u0004R\u00020\u0000X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/mp3player/ui/QueueBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "adapter", "Lcom/mp3player/ui/QueueBottomSheet$QueueAdapter;", "btnClear", "Landroid/widget/Button;", "listView", "Landroid/widget/ListView;", "tvEmpty", "Landroid/widget/TextView;", "getMusicPlayer", "Lcom/mp3player/MusicPlayer;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "refreshQueue", "", "QueueAdapter", "app_debug"})
public final class QueueBottomSheet extends com.google.android.material.bottomsheet.BottomSheetDialogFragment {
    private android.widget.ListView listView;
    private android.widget.Button btnClear;
    private android.widget.TextView tvEmpty;
    @org.jetbrains.annotations.NotNull
    private final com.mp3player.ui.QueueBottomSheet.QueueAdapter adapter = null;
    
    public QueueBottomSheet() {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void refreshQueue() {
    }
    
    private final com.mp3player.MusicPlayer getMusicPlayer() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0007H\u0016J$\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0014\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/mp3player/ui/QueueBottomSheet$QueueAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/mp3player/ui/QueueBottomSheet;)V", "items", "", "Lcom/mp3player/Song;", "getCount", "", "getItem", "", "i", "getItemId", "", "getView", "Landroid/view/View;", "position", "convertView", "parent", "Landroid/view/ViewGroup;", "update", "", "newItems", "", "app_debug"})
    public final class QueueAdapter extends android.widget.BaseAdapter {
        @org.jetbrains.annotations.NotNull
        private final java.util.List<com.mp3player.Song> items = null;
        
        public QueueAdapter() {
            super();
        }
        
        public final void update(@org.jetbrains.annotations.NotNull
        java.util.List<com.mp3player.Song> newItems) {
        }
        
        @java.lang.Override
        public int getCount() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.Object getItem(int i) {
            return null;
        }
        
        @java.lang.Override
        public long getItemId(int i) {
            return 0L;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public android.view.View getView(int position, @org.jetbrains.annotations.Nullable
        android.view.View convertView, @org.jetbrains.annotations.Nullable
        android.view.ViewGroup parent) {
            return null;
        }
    }
}