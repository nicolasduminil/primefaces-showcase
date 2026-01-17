package fr.simplex_software.workshop.primefaces_showcase.controller.chapter5;

import fr.simplex_software.workshop.primefaces_showcase.model.*;
import fr.simplex_software.workshop.primefaces_showcase.model.chapter5.*;
import fr.simplex_software.workshop.primefaces_showcase.utils.*;
import jakarta.faces.view.*;
import jakarta.inject.*;
import org.primefaces.event.*;
import org.primefaces.model.*;

import java.io.*;

@Named
@ViewScoped
public class TreeTableBean implements Serializable
{
  private final TreeNode<TreeTableElement> root;

  private TreeNode<TreeTableElement> selectedItem;
  private TreeNode<TreeTableElement> selectedItemForContextMenu;
  private TreeNode<TreeTableElement>[] selectedItems;

  public TreeTableBean()
  {
    root = new DefaultTreeNode<>(new TreeTableElement("root", null, null), null);

    TreeNode<TreeTableElement> node1 = createNode("node", "Node1", "N1 1st Column", "N1 2nd Column", root);
    TreeNode<TreeTableElement> node2 = createNode("node", "Node2", "N2 1st Column", "N2 2nd Column", root);

    createNode("leaf", "Node1.1", "N11 1st Column", "N11 2nd Column", node1);
    createNode("leaf", "Node1.2", "N12 1st Column", "N12 2nd Column", node1);

    TreeNode<TreeTableElement> node21 = createNode("node", "Node2.1", "N21 1st Column", "N21 2nd Column", node2);
    createNode("leaf", "Node2.1.1", "N211 1st Column", "N211 2nd Column", node21);
  }

  public void onNodeExpand(NodeExpandEvent event)
  {
    MessageUtil.addInfoMessageWithoutKey("Expanded", event.getTreeNode().getData().toString());
  }

  public void onNodeCollapse(NodeCollapseEvent event)
  {
    MessageUtil.addInfoMessageWithoutKey("Collapsed", event.getTreeNode().getData().toString());
  }

  public void onNodeSelect(NodeSelectEvent event)
  {
    MessageUtil.addInfoMessageWithoutKey("Selected", event.getTreeNode().getData().toString());
  }

  public void onNodeUnselect(NodeUnselectEvent event)
  {
    MessageUtil.addInfoMessageWithoutKey("Unselected", event.getTreeNode().getData().toString());
  }

  public void onColResize(ColumnResizeEvent event)
  {
    MessageUtil.addInfoMessageWithoutKey("Resized", event.getColumn().toString());
  }

  public void deleteNode()
  {
    selectedItem.getChildren().clear();
    selectedItem.getParent().getChildren().remove(selectedItem);
    selectedItem.setParent(null);

    selectedItem = null;
  }

  public TreeNode<TreeTableElement> getRoot()
  {
    return root;
  }

  public TreeNode<TreeTableElement> getSelectedItem()
  {
    return selectedItem;
  }

  public void setSelectedItem(TreeNode<TreeTableElement> selectedItem)
  {
    this.selectedItem = selectedItem;
  }

  public TreeNode<TreeTableElement> getSelectedItemForContextMenu()
  {
    return selectedItemForContextMenu;
  }

  public void setSelectedItemForContextMenu(TreeNode<TreeTableElement> selectedItemForContextMenu)
  {
    this.selectedItemForContextMenu = selectedItemForContextMenu;
  }

  public TreeNode<TreeTableElement>[] getSelectedItems()
  {
    return selectedItems;
  }

  public void setSelectedItems(TreeNode<TreeTableElement>[] selectedItems)
  {
    this.selectedItems = selectedItems;
  }

  private TreeNode<TreeTableElement> createNode(String type, String name, String col1, String col2, TreeNode<TreeTableElement> parent)
  {
    return new DefaultTreeNode<>(type, new TreeTableElement(name, col1, col2), parent);
  }
}
