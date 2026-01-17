package fr.simplex_software.workshop.primefaces_showcase.controller.chapter5;

import fr.simplex_software.workshop.primefaces_showcase.model.*;
import fr.simplex_software.workshop.primefaces_showcase.utils.*;
import jakarta.faces.view.*;
import jakarta.inject.*;
import org.primefaces.event.*;
import org.primefaces.model.*;

import java.io.*;

@Named
@ViewScoped
public class TreeDataBean implements Serializable
{

  private final TreeNode<BookTreeNode> root;
  private final TreeNode<BookTreeNode> root2;
  private final TreeNode<BookTreeNode> rootWithType;

  private TreeNode<BookTreeNode> selectedNode;
  private TreeNode<BookTreeNode> selectedNode1;
  private TreeNode<BookTreeNode> selectedNode2;
  private TreeNode<BookTreeNode>[] selectedNodes;

  public TreeDataBean()
  {
    root = new DefaultTreeNode<>(new BookTreeNode("root", null), null);
    TreeNode<BookTreeNode> node1 = createNode("Node1", root);
    TreeNode<BookTreeNode> node2 = createNode("Node2", root);

    createNode("Node1.1", node1);
    createNode("Node1.2", node1);

    TreeNode<BookTreeNode> node21 = createNode("Node2.1", node2);
    createNode("Node2.1.1", node21);

    root2 = new DefaultTreeNode<>(new BookTreeNode("root2", null), null);
    TreeNode<BookTreeNode> t2_node1 = createNode("Node1", root2);
    TreeNode<BookTreeNode> t2_node2 = createNode("Node2", root2);

    createNode("Node1.1", t2_node1);
    createNode("Node1.2", t2_node1);

    TreeNode<BookTreeNode> t2_node21 = createNode("Node2.1", t2_node2);
    createNode("Node2.1.1", t2_node21);
    rootWithType = new DefaultTreeNode<>(new BookTreeNode("node", "Root"), null);
    TreeNode<BookTreeNode> node1_type = createNode("node", "Node1", rootWithType);
    TreeNode<BookTreeNode> node2_type = createNode("node", "Node2", rootWithType);

    createNode("leaf", "Node1.1", node1_type);
    createNode("leaf", "Node1.2", node1_type);

    TreeNode<BookTreeNode> node21_type = createNode("node", "Node2.1", node2_type);
    createNode("leaf", "Node2.1.1", node21_type);
  }

  public void displaySelected()
  {
    if (selectedNode != null)
    {
      MessageUtil.addInfoMessageWithoutKey("Selected", selectedNode.getData().toString());
    }

    if (selectedNodes != null && selectedNodes.length > 0)
    {
      StringBuilder builder = new StringBuilder();

      for (TreeNode<BookTreeNode> node : selectedNodes)
      {
        builder.append(node.getData().toString());
        builder.append("<br />");
      }

      MessageUtil.addInfoMessageWithoutKey("Selected", builder.toString());
    }

    selectedNode = null;
    selectedNodes = null;
  }

  public void onNodeExpand(NodeExpandEvent event)
  {
    MessageUtil.addInfoMessageWithoutKey("Expanded", event.getTreeNode().toString());
  }

  public void onNodeCollapse(NodeCollapseEvent event)
  {
    MessageUtil.addInfoMessageWithoutKey("Collapsed", event.getTreeNode().toString());
  }

  public void onNodeSelect(NodeSelectEvent event)
  {
    MessageUtil.addInfoMessageWithoutKey("Selected", event.getTreeNode().toString());
  }

  public void onNodeUnselect(NodeUnselectEvent event)
  {
    MessageUtil.addInfoMessageWithoutKey("Unselected", event.getTreeNode().toString());
  }

  public void deleteNode()
  {
    selectedNode.getChildren().clear();
    selectedNode.getParent().getChildren().remove(selectedNode);
    selectedNode.setParent(null);

    selectedNode = null;
  }

  public TreeNode<BookTreeNode> getRoot()
  {
    return root;
  }

  public TreeNode<BookTreeNode> getRoot2()
  {
    return root2;
  }

  public TreeNode<BookTreeNode> getRootWithType()
  {
    return rootWithType;
  }

  public TreeNode<BookTreeNode> getSelectedNode()
  {
    return selectedNode;
  }

  public void setSelectedNode(TreeNode<BookTreeNode> selectedNode)
  {
    this.selectedNode = selectedNode;
  }

  public TreeNode<BookTreeNode> getSelectedNode1()
  {
    return selectedNode1;
  }

  public void setSelectedNode1(TreeNode<BookTreeNode> selectedNode1)
  {
    this.selectedNode1 = selectedNode1;
  }

  public TreeNode<BookTreeNode> getSelectedNode2()
  {
    return selectedNode2;
  }

  public void setSelectedNode2(TreeNode<BookTreeNode> selectedNode2)
  {
    this.selectedNode2 = selectedNode2;
  }

  public TreeNode<BookTreeNode>[] getSelectedNodes()
  {
    return selectedNodes;
  }

  public void setSelectedNodes(TreeNode<BookTreeNode>[] selectedNodes)
  {
    this.selectedNodes = selectedNodes;
  }

  private TreeNode<BookTreeNode> createNode(String label, TreeNode<BookTreeNode> parent)
  {
    return new DefaultTreeNode<>(new BookTreeNode("node", label), parent);
  }

  private TreeNode<BookTreeNode> createNode(String type, String label, TreeNode<BookTreeNode> parent)
  {
    return new DefaultTreeNode<>(new BookTreeNode(type, label), parent);
  }
}