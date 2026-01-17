package fr.simplex_software.workshop.primefaces_showcase.controller.chapter6;

import fr.simplex_software.workshop.primefaces_showcase.model.*;
import jakarta.annotation.*;
import jakarta.faces.application.*;
import jakarta.faces.context.*;
import jakarta.faces.view.*;
import jakarta.inject.*;
import org.primefaces.event.*;
import org.primefaces.model.*;

@Named
@ViewScoped
public class ContextMenuBean extends BaseMenuBean
{
  private TreeNode<String> root;
  private TreeNode<String> selectedNode;

  @PostConstruct
  protected void initialize()
  {
    root = new DefaultTreeNode<>("Root", null);

    TreeNode<String> node0 = new DefaultTreeNode<>("Folder 0", root);
    TreeNode<String> node1 = new DefaultTreeNode<>("Folder 1", root);
    TreeNode<String> node2 = new DefaultTreeNode<>("Folder 2", root);
    TreeNode<String> node00 = new DefaultTreeNode<>("Folder 0.0", node0);
    TreeNode<String> node01 = new DefaultTreeNode<>("Folder 0.1", node0);
    TreeNode<String> node10 = new DefaultTreeNode<>("Folder 1.0", node1);
    new DefaultTreeNode<>("File 1.1", node1);
    new DefaultTreeNode<>("File 2.0", node2);
    new DefaultTreeNode<>("File 0.0.0", node00);
    new DefaultTreeNode<>("File 0.0.1", node00);
    new DefaultTreeNode<>("File 0.1.0", node01);
    new DefaultTreeNode<>("File 1.0.0", node10);
  }

  public TreeNode<String> getRoot()
  {
    return root;
  }

  public TreeNode<String> getSelectedNode()
  {
    return selectedNode;
  }

  public void setSelectedNode(TreeNode<String> selectedNode)
  {
    this.selectedNode = selectedNode;
  }

  public void onNodeSelect(NodeSelectEvent event)
  {
    selectedNode = event.getTreeNode();
  }

  public void onNodeUnselect()
  {
    selectedNode = null;
  }

  public void viewNode()
  {
    if (selectedNode != null)
      FacesContext.getCurrentInstance().addMessage(null,
        new FacesMessage(
          FacesMessage.SEVERITY_INFO,
          "Selected", selectedNode.getData()));
  }

  public void deleteNode()
  {
    if (selectedNode != null)
    {
      selectedNode.getChildren().clear();
      selectedNode.getParent().getChildren().remove(selectedNode);
      selectedNode.setParent(null);
      selectedNode = null;
    }
  }
}
