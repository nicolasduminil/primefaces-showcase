package fr.simplex_software.workshop.primefaces_showcase.controller.chapter2;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@ViewScoped
public class TreeBean implements Serializable
{
  private final TreeNode<BookTreeNode> root;

  public TreeBean()
  {
    root = new DefaultTreeNode<>("Root", null);

    TreeNode<BookTreeNode> node0 = new DefaultTreeNode<>("Tree node 0", root);
    node0.setExpanded(true);

    TreeNode<BookTreeNode> node1 = new DefaultTreeNode<>("Tree node 1", root);
    new DefaultTreeNode<>("Tree node 2", root);

    TreeNode<BookTreeNode> node00 = new DefaultTreeNode<>("Tree node 0.0", node0);
    node00.setExpanded(true);

    TreeNode<BookTreeNode> node01 = new DefaultTreeNode<>("Tree node 0.1", node0);

    TreeNode<BookTreeNode> node10 = new DefaultTreeNode<>("Tree node 1.0", node1);
    new DefaultTreeNode<>("Tree node 1.1", node1);

    TreeNode<BookTreeNode> node000 = new DefaultTreeNode<>("Tree node 0.0.0", node00);
    node000.setExpanded(true);

    new DefaultTreeNode<>("Tree node 0.0.1", node00);
    new DefaultTreeNode<>("Tree node 0.1.0", node01);

    new DefaultTreeNode<>("Tree node 1.0.0", node10);
  }

  public TreeNode<BookTreeNode> getRoot()
  {
    return root;
  }
}
