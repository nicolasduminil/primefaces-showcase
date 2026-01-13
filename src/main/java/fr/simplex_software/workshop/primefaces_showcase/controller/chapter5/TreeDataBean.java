package fr.simplex_software.workshop.primefaces_showcase.controller.chapter5;

import fr.simplex_software.workshop.primefaces_showcase.utils.MessageUtil;
import org.primefaces.event.NodeCollapseEvent;
import org.primefaces.event.NodeExpandEvent;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.event.NodeUnselectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 * User: mertcaliskan
 * Date: 8/28/12
 */
@Named
@ViewScoped
public class TreeDataBean implements Serializable {

    private TreeNode<BookTreeNode> root;
    private TreeNode<BookTreeNode> root2;
    private TreeNode<BookTreeNode> rootWithType;

    private TreeNode<BookTreeNode> selectedNode;
    private TreeNode<BookTreeNode> selectedNode1;
    private TreeNode<BookTreeNode> selectedNode2;
    private TreeNode[] selectedNodes;

    public TreeDataBean() {
        root = new DefaultTreeNode<>("Root", null);
        TreeNode<BookTreeNode> node1 = new DefaultTreeNode<>("Node1", root);
        TreeNode<BookTreeNode> node2 = new DefaultTreeNode<>("Node2", root);

        TreeNode<BookTreeNode> node11 = new DefaultTreeNode<>("Node1.1", node1);
        TreeNode<BookTreeNode> node12 = new DefaultTreeNode<>("Node1.2", node1);

        TreeNode<BookTreeNode> node21 = new DefaultTreeNode<>("Node2.1", node2);
        TreeNode<BookTreeNode> node211 = new DefaultTreeNode<>("Node2.1.1", node21);

        //root2
        root2 = new DefaultTreeNode<>("Root", null);
        TreeNode<BookTreeNode> t2_node1 = new DefaultTreeNode<>("Node1", root2);
        TreeNode<BookTreeNode> t2_node2 = new DefaultTreeNode<>("Node2", root2);

        TreeNode<BookTreeNode> t2_node11 = new DefaultTreeNode<>("Node1.1", t2_node1);
        TreeNode<BookTreeNode> t2_node12 = new DefaultTreeNode<>("Node1.2", t2_node1);

        TreeNode<BookTreeNode> t2_node21 = new DefaultTreeNode<>("Node2.1", t2_node2);
        TreeNode<BookTreeNode> t2_node211 = new DefaultTreeNode<>("Node2.1.1", t2_node21);

        // tree with node types
        rootWithType = new DefaultTreeNode<>("node", "Root", null);
        TreeNode<BookTreeNode> node1_type = new DefaultTreeNode<>("node", "Node1", rootWithType);
        TreeNode<BookTreeNode> node2_type = new DefaultTreeNode<>("node", "Node2", rootWithType);

        TreeNode<BookTreeNode> node11_type = new DefaultTreeNode<>("leaf", "Node1.1", node1_type);
        TreeNode<BookTreeNode> node12_type = new DefaultTreeNode<>("leaf", "Node1.2", node1_type);

        TreeNode<BookTreeNode> node21_type = new DefaultTreeNode<>("node", "Node2.1", node2_type);
        TreeNode<BookTreeNode> node211_type = new DefaultTreeNode<>("leaf", "Node2.1.1", node21_type);
    }

    public void displaySelected() {
        if(selectedNode != null) {
            MessageUtil.addInfoMessageWithoutKey("Selected", selectedNode.getData().toString());
        }

        if(selectedNodes != null && selectedNodes.length > 0) {
            StringBuilder builder = new StringBuilder();

            for(TreeNode<BookTreeNode> node : selectedNodes) {
                builder.append(node.getData().toString());
                builder.append("<br />");
            }

            MessageUtil.addInfoMessageWithoutKey("Selected", builder.toString());
        }

        selectedNode = null;
        selectedNodes = null;
    }

    public void onNodeExpand(NodeExpandEvent event) {
        MessageUtil.addInfoMessageWithoutKey("Expanded", event.getTreeNode<>().toString());
    }

    public void onNodeCollapse(NodeCollapseEvent event) {
        MessageUtil.addInfoMessageWithoutKey("Collapsed", event.getTreeNode<>().toString());
    }

    public void onNodeSelect(NodeSelectEvent event) {
        MessageUtil.addInfoMessageWithoutKey("Selected", event.getTreeNode<>().toString());
    }

    public void onNodeUnselect(NodeUnselectEvent event) {
        MessageUtil.addInfoMessageWithoutKey("Unselected", event.getTreeNode<>().toString());
    }

    public void deleteNode() {
        selectedNode.getChildren().clear();
        selectedNode.getParent().getChildren().remove(selectedNode);
        selectedNode.setParent(null);

        selectedNode = null;
    }

    public TreeNode<BookTreeNode> getRoot() {
        return root;
    }

    public TreeNode<BookTreeNode> getRoot2() {
        return root2;
    }

    public TreeNode<BookTreeNode> getRootWithType() {
        return rootWithType;
    }

    public TreeNode<BookTreeNode> getSelectedNode() {
        return selectedNode;
    }

    public void setSelectedNode(TreeNode<BookTreeNode> selectedNode) {
        this.selectedNode = selectedNode;
    }

    public TreeNode<BookTreeNode> getSelectedNode1() {
        return selectedNode1;
    }

    public void setSelectedNode1(TreeNode<BookTreeNode> selectedNode1) {
        this.selectedNode1 = selectedNode1;
    }

    public TreeNode<BookTreeNode> getSelectedNode2() {
        return selectedNode2;
    }

    public void setSelectedNode2(TreeNode<BookTreeNode> selectedNode2) {
        this.selectedNode2 = selectedNode2;
    }

    public TreeNode[] getSelectedNodes() {
        return selectedNodes;
    }

    public void setSelectedNodes(TreeNode[] selectedNodes) {
        this.selectedNodes = selectedNodes;
    }
}