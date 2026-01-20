package fr.simplex_software.workshop.primefaces_showcase.controller;

import fr.simplex_software.workshop.primefaces_showcase.*;
import jakarta.annotation.*;
import jakarta.enterprise.context.*;
import jakarta.faces.context.*;
import jakarta.inject.*;
import org.primefaces.event.*;
import org.primefaces.model.*;
import fr.simplex_software.workshop.primefaces_showcase.model.*;

import java.io.*;
import java.util.*;
import java.util.function.*;

@Named
@SessionScoped
public class BookBean implements Serializable
{
  private final TreeNode<BookTreeNode> root;
  private TreeNode<BookTreeNode> selectedNode;
  @Inject
  BookConfig bookConfig;

  public BookBean()
  {
    root = new DefaultTreeNode<>(new BookTreeNode("root", null), null);
  }

  @PostConstruct
  public void postConstruct()
  {
    bookConfig.chapters().values().forEach(chapter ->
        populateChapter(chapter.title(), chapter.pages()));
  }

  public TreeNode<BookTreeNode> getRoot()
  {
    return root;
  }

  public TreeNode<BookTreeNode> getSelectedNode()
  {
    return selectedNode;
  }

  public void setSelectedNode(TreeNode<BookTreeNode> selectedNode)
  {
    this.selectedNode = selectedNode;
  }

  public void onNodeSelect(NodeSelectEvent event)
  {
    if (root != event.getTreeNode().getParent())
    {
      root.getChildren().forEach(node ->
        node.setExpanded(node.equals(selectedNode.getParent())));
     FacesContext fc = FacesContext.getCurrentInstance();
      fc.getApplication().getNavigationHandler().handleNavigation(fc, "null",
        "/views/%s?faces-redirect=true".formatted(((BookTreeNode)event
          .getTreeNode().getData()).getView()));
    }
  }

  private void populateChapter(String chapterTitle, List<BookConfig.Page> pages)
  {
    TreeNode<BookTreeNode> chapterNode =
      new DefaultTreeNode<>("chapter", new BookTreeNode(chapterTitle, null), root);
    pages.forEach(page ->
      new DefaultTreeNode<>("chapteritem", new BookTreeNode(page.name(), page.view()), chapterNode));
   }
}
