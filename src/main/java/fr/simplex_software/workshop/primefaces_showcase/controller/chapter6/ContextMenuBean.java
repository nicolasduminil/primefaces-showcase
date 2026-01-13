package fr.simplex_software.workshop.primefaces_showcase.controller.chapter6;

import org.primefaces.event.NodeSelectEvent;
import org.primefaces.event.NodeUnselectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

/**
 * ContextMenuBean
 *
 * @author  Oleg Varaksin / last modified by $Author: $
 * @version $Revision: 1.0 $
 */
@Named
@ViewScoped
public class ContextMenuBean extends BaseMenuBean {

    private TreeNode<BookTreeNode> root;
    private TreeNode<BookTreeNode> selectedNode;

    @PostConstruct
    protected void initialize() {
        root = new DefaultTreeNode<>("Root", null);

        TreeNode<BookTreeNode> node0 = new DefaultTreeNode<>("Folder 0", root);
        TreeNode<BookTreeNode> node1 = new DefaultTreeNode<>("Folder 1", root);
        TreeNode<BookTreeNode> node2 = new DefaultTreeNode<>("Folder 2", root);
        TreeNode<BookTreeNode> node00 = new DefaultTreeNode<>("Folder 0.0", node0);
        TreeNode<BookTreeNode> node01 = new DefaultTreeNode<>("Folder 0.1", node0);
        TreeNode<BookTreeNode> node10 = new DefaultTreeNode<>("Folder 1.0", node1);
        new DefaultTreeNode<>("File 1.1", node1);
        new DefaultTreeNode<>("File 2.0", node2);
        new DefaultTreeNode<>("File 0.0.0", node00);
        new DefaultTreeNode<>("File 0.0.1", node00);
        new DefaultTreeNode<>("File 0.1.0", node01);
        new DefaultTreeNode<>("File 1.0.0", node10);
    }

    public TreeNode<BookTreeNode> getRoot() {
        return root;
    }

    public TreeNode<BookTreeNode> getSelectedNode() {
        return selectedNode;
    }

    public void setSelectedNode(TreeNode<BookTreeNode> selectedNode) {
        this.selectedNode = selectedNode;
    }

    public void onNodeSelect(NodeSelectEvent event) {
        selectedNode = event.getTreeNode<>();
    }

    public void onNodeUnselect(NodeUnselectEvent event) {
        selectedNode = null;
    }

    public void viewNode() {
        if (selectedNode == null) {
            return;
        }

        FacesMessage msg = new FacesMessage(
            FacesMessage.SEVERITY_INFO,
            "Selected", selectedNode.getData().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void deleteNode() {
        if (selectedNode == null) {
            return;
        }

        selectedNode.getChildren().clear();
        selectedNode.getParent().getChildren().remove(selectedNode);
        selectedNode.setParent(null);

        selectedNode = null;
    }
}
