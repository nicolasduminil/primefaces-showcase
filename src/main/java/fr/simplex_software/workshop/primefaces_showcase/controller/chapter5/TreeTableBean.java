package fr.simplex_software.workshop.primefaces_showcase.controller.chapter5;

import fr.simplex_software.workshop.primefaces_showcase.model.chapter5.TreeTableElement;
import fr.simplex_software.workshop.primefaces_showcase.utils.MessageUtil;
import org.primefaces.event.*;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 * User: mertcaliskan
 * Date: 8/31/12
 */
@Named
@ViewScoped
public class TreeTableBean implements Serializable {

    private TreeNode<BookTreeNode> root;

    private TreeNode<BookTreeNode> selectedItem;
    private TreeNode<BookTreeNode> selectedItem2;
    private TreeNode<BookTreeNode> selectedItemForContextMenu;
    private TreeNode[] selectedItems;

    public TreeTableBean() {
        root = new DefaultTreeNode<>("root", null);

        TreeNode<BookTreeNode> node1 = new DefaultTreeNode<>("node", new TreeTableElement("Node1", "N1 1st Column", "N1 2nd Column"), root);
        TreeNode<BookTreeNode> node2 = new DefaultTreeNode<>("node", new TreeTableElement("Node2", "N2 1st Column", "N2 2nd Column"), root);

        TreeNode<BookTreeNode> node11 = new DefaultTreeNode<>("leaf", new TreeTableElement("Node1.1", "N11 1st Column", "N11 2nd Column"), node1);
        TreeNode<BookTreeNode> node12 = new DefaultTreeNode<>("leaf", new TreeTableElement("Node1.2", "N12 1st Column", "N12 2nd Column"), node1);

        TreeNode<BookTreeNode> node21 = new DefaultTreeNode<>("node", new TreeTableElement("Node2.1", "N21 1st Column", "N21 2nd Column"), node2);
        TreeNode<BookTreeNode> node211 = new DefaultTreeNode<>("leaf", new TreeTableElement("Node2.1.1", "N211 1st Column", "N211 2nd Column"), node21);
    }

    public void onNodeExpand(NodeExpandEvent event) {
        MessageUtil.addInfoMessageWithoutKey("Expanded", event.getTreeNode<>().getData().toString());
    }

    public void onNodeCollapse(NodeCollapseEvent event) {
        MessageUtil.addInfoMessageWithoutKey("Collapsed", event.getTreeNode<>().getData().toString());
    }

    public void onNodeSelect(NodeSelectEvent event) {
        MessageUtil.addInfoMessageWithoutKey("Selected", event.getTreeNode<>().getData().toString());
    }

    public void onNodeUnselect(NodeUnselectEvent event) {
        MessageUtil.addInfoMessageWithoutKey("Unselected", event.getTreeNode<>().getData().toString());
    }

    public void onColResize(ColumnResizeEvent event) {
        MessageUtil.addInfoMessageWithoutKey("Resized", event.getColumn().toString());
    }

    public void deleteNode() {
        selectedItem.getChildren().clear();
        selectedItem.getParent().getChildren().remove(selectedItem);
        selectedItem.setParent(null);

        selectedItem = null;
    }

    public TreeNode<BookTreeNode> getRoot() {
        return root;
    }

    public TreeNode<BookTreeNode> getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(TreeNode<BookTreeNode> selectedItem) {
        this.selectedItem = selectedItem;
    }

    public TreeNode<BookTreeNode> getSelectedItem2() {
        return selectedItem2;
    }

    public void setSelectedItem2(TreeNode<BookTreeNode> selectedItem2) {
        this.selectedItem2 = selectedItem2;
    }

    public TreeNode<BookTreeNode> getSelectedItemForContextMenu() {
        return selectedItemForContextMenu;
    }

    public void setSelectedItemForContextMenu(TreeNode<BookTreeNode> selectedItemForContextMenu) {
        this.selectedItemForContextMenu = selectedItemForContextMenu;
    }

    public TreeNode[] getSelectedItems() {
        return selectedItems;
    }

    public void setSelectedItems(TreeNode[] selectedItems) {
        this.selectedItems = selectedItems;
    }
}
