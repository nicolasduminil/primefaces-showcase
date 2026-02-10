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
  private final TreeNode<String> root;
  private final TreeNode<String> root2;
  private final TreeNode<String> rootWithType;

  private TreeNode<String> selectedNode;
  private TreeNode<String> selectedNode1;
  private TreeNode<String> selectedNode2;
  private TreeNode<String>[] selectedNodes;

  public TreeDataBean()
  {
    root = new DefaultTreeNode<>("Root", null);
    TreeNode<String> node1 = createNode("Node1", root);
    TreeNode<String> node2 = createNode("Node2", root);

    createNode("Node1.1", node1);
    createNode("Node1.2", node1);

    TreeNode<String> node21 = createNode("Node2.1", node2);
    createNode("Node2.1.1", node21);

    root2 = new DefaultTreeNode<>("Root", null);
    TreeNode<String> t2_node1 = createNode("Node1", root2);
    TreeNode<String> t2_node2 = createNode("Node2", root2);

    createNode("Node1.1", t2_node1);
    createNode("Node1.2", t2_node1);

    TreeNode<String> t2_node21 = createNode("Node2.1", t2_node2);
    createNode("Node2.1.1", t2_node21);
    rootWithType = new DefaultTreeNode<>("node", "Root", null);
    TreeNode<String> node1_type = createNode("node", "Node1", rootWithType);
    TreeNode<String> node2_type = createNode("node", "Node2", rootWithType);

    createNode("leaf", "Node1.1", node1_type);
    createNode("leaf", "Node1.2", node1_type);

    TreeNode<String> node21_type = createNode("node", "Node2.1", node2_type);
    createNode("leaf", "Node2.1.1", node21_type);
  }

  public void displaySelected()
  {
    if (selectedNode != null)
    {
      MessageUtil.addInfoMessageWithoutKey("Selected", selectedNode.getData());
    }

    if (selectedNodes != null && selectedNodes.length > 0)
    {
      StringBuilder builder = new StringBuilder();

      for (TreeNode<String> node : selectedNodes)
      {
        builder.append(node.getData());
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

  public TreeNode<String> getRoot()
  {
    return root;
  }

  public TreeNode<String> getRoot2()
  {
    return root2;
  }

  public TreeNode<String> getRootWithType()
  {
    return rootWithType;
  }

  public TreeNode<String> getSelectedNode()
  {
    return selectedNode;
  }

  public void setSelectedNode(TreeNode<String> selectedNode)
  {
    this.selectedNode = selectedNode;
  }

  public TreeNode<String> getSelectedNode1()
  {
    return selectedNode1;
  }

  public void setSelectedNode1(TreeNode<String> selectedNode1)
  {
    this.selectedNode1 = selectedNode1;
  }

  public TreeNode<String> getSelectedNode2()
  {
    return selectedNode2;
  }

  public void setSelectedNode2(TreeNode<String> selectedNode2)
  {
    this.selectedNode2 = selectedNode2;
  }

  public TreeNode<String>[] getSelectedNodes()
  {
    return selectedNodes;
  }

  public void setSelectedNodes(TreeNode<String>[] selectedNodes)
  {
    this.selectedNodes = selectedNodes;
  }

  private TreeNode<String> createNode(String label, TreeNode<String> parent)
  {
    return new DefaultTreeNode<>(label, parent);
  }

  private TreeNode<String> createNode(String type, String label, TreeNode<String> parent)
  {
    return new DefaultTreeNode<>(type, label, parent);
  }
}