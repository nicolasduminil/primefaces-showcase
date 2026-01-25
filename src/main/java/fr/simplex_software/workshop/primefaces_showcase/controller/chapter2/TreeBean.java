package fr.simplex_software.workshop.primefaces_showcase.controller.chapter2;

import fr.simplex_software.workshop.primefaces_showcase.model.*;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@ViewScoped
public class TreeBean implements Serializable
{
  private final TreeNode<String> root;

  public TreeBean()
  {
    root = new DefaultTreeNode<>("Root", null);

    TreeNode<String> n0 = createNode("Tree node 0", root, true);
    TreeNode<String> n00 = createNode("Tree node 0.0", n0, true);
    createNode("Tree node 0.0.0", n00, true);
    createNode("Tree node 0.0.1", n00, false);
    createNode("Tree node 0.1", n0, false);
    createNode("Tree node 0.1.0", n0, false);

    TreeNode<String> n1 = createNode("Tree node 1", root, false);
    TreeNode<String> n10 = createNode("Tree node 1.0", n1, false);
    createNode("Tree node 1.0.0", n10, false);
    createNode("Tree node 1.1", n1, false);

    createNode("Tree node 2", root, false);
  }

  public TreeNode<String> getRoot()
  {
    return root;
  }

  private TreeNode<String> createNode(String label, TreeNode<String> parent, boolean expanded)
  {
    TreeNode<String> node = new DefaultTreeNode<>(label, parent);
    node.setExpanded(expanded);
    return node;
  }
}
