package fr.simplex_software.workshop.primefaces_showcase.controller;

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
  private static final String NODE_TYPE = "chapteritem";
  private record Page(String name, String view) {}
  private final TreeNode<BookTreeNode> root;
  private TreeNode<BookTreeNode> selectedNode;

  public BookBean()
  {
    root = new DefaultTreeNode<>(new BookTreeNode("root", null), null);
    populateChapter("Getting Started with PrimeFaces", List.of(
      new Page("Your first page with PrimeFaces Component", "chapter1/yourFirstPage.xhtml"),
      new Page("Internationalization of the Faces Messages", "chapter1/internationalization.xhtml"),
      new Page("Basic Partial Page Rendering", "chapter1/basicPPR.xhtml"),
      new Page("Update Component in Different Naming Container", "chapter1/componentInDifferentNamingContainer.xhtml"),
      new Page("Partial Processing", "chapter1/partialProcessing.xhtml"),
      new Page("PrimeFaces Selectors", "chapter1/pfs.xhtml"),
      new Page("Processing with Fragment", "chapter1/fragment.xhtml"),
      new Page("Partial View Submit", "chapter1/partialSubmit.xhtml"),
      new Page("Localization of Calendar Component", "chapter1/localization.xhtml"),
      new Page("Right to left language support", "chapter1/rightToLeft.xhtml"),
      new Page("Localization with Resources", "chapter1/localizationWithResources.xhtml"),
      new Page("Improved Resource Ordering", "chapter1/resourceOrdering.xhtml")));
    populateChapter("Theming Concept", List.of(
      new Page("Customizing default theme styles", "chapter2/customThemeStyles.xhtml"),
      new Page("Customizing default styles on input components", "chapter2/customInputStyles.xhtml"),
      new Page("Stateless theme switcher", "chapter2/statelessThemeSwitcher.xhtml"),
      new Page("Stateful theme switcher", "chapter2/statefulThemeSwitcher.xhtml"),
      new Page("Font Awesome", "chapter2/fontAwesome.xhtml")));
    populateChapter("Enhanced Inputs and Selects", List.of(
      new Page("Formatted input with InputMask", "chapter3/inputMask.xhtml"),
      new Page("Auto Suggestion with AutoComplete", "chapter3/autoComplete.xhtml"),
      new Page("Usable Features of InputTextArea", "chapter3/inputTextArea.xhtml"),
      new Page("SelectBooleanCheckbox and SelectManyCheckbox", "chapter3/selectBooleanCheckboxSelectManyCheckbox.xhtml"),
      new Page("Choosing single item with selectOneMenu", "chapter3/selectOneMenu.xhtml"),
      new Page("Basic and Advanced Calendar Scenarios", "chapter3/calendar.xhtml"),
      new Page("Spinner - Different ways to provide input", "chapter3/spinner.xhtml"),
      new Page("Slider - Different ways to provide input", "chapter3/slider.xhtml"),
      new Page("Rich Text Editing with the Editor", "chapter3/editor.xhtml"),
      new Page("Advanced Editing with in-place Editor", "chapter3/inPlaceEditor.xhtml"),
      new Page("Enhanced Password Input", "chapter3/password.xhtml"),
      new Page("Star Based Rating Input", "chapter3/rating.xhtml")));
    populateChapter("Grouping Content with Panels", List.of(
      new Page("Basic Panel", "chapter4/panel.xhtml"),
      new Page("PanelGrid", "chapter4/panelGrid.xhtml"),
      new Page("Accordion Panel", "chapter4/accordionPanel.xhtml"),
      new Page("TabView", "chapter4/tabView.xhtml"),
      new Page("Fieldset", "chapter4/fieldset.xhtml"),
      new Page("Grid System", "chapter4/grid.xhtml"),
      new Page("Toolbar", "chapter4/toolbar.xhtml"),
      new Page("Nested Messages", "chapter4/nestedMessages.xhtml"),
      new Page("Nested DataTable", "chapter4/nestedDataTable.xhtml"),
      new Page("Nested Panels", "chapter4/nestedPanels.xhtml")));
    populateChapter("Data Iteration Components", List.of(
      new Page("Selecting rows in DataTable", "chapter5/dataTableSelectRow.xhtml"),
      new Page("Sorting and Filtering data in DataTable", "chapter5/dataTableSortFilter.xhtml"),
      new Page("In-cell editing with DataTable", "chapter5/dataTableInCellEdit.xhtml"),
      new Page("Resizing, Reordering and Toggling of columns in dataTable", "chapter5/dataTableResizeReorderToggle.xhtml"),
      new Page("Making dataTable Responsive", "chapter5/responsiveDataTable.xhtml"),
      new Page("Using subTable for grouping", "chapter5/subTable.xhtml"),
      new Page("Handling tons of data - LazyDataModel", "chapter5/dataTableLazyDataModel.xhtml"),
      new Page("Listing data with DataList", "chapter5/dataList.xhtml"),
      new Page("Listing data with PickList", "chapter5/pickList.xhtml"),
      new Page("Listing data with OrderList", "chapter5/orderList.xhtml"),
      new Page("Visualizing data with Tree", "chapter5/tree.xhtml"),
      new Page("Visualizing data with TreeTable", "chapter5/treeTable.xhtml"),
      new Page("Exporting data in various formats", "chapter5/dataExport.xhtml"),
      new Page("Managing events with schedule by leveraging lazy loading", "chapter5/scheduleLazyLoad.xhtml"),
      new Page("Visualizing data with Data Scroller", "chapter5/dataScroller.xhtml")));
    populateChapter("Endless Menu Variations", List.of(
      new Page("Dynamic and static positioned menus", "chapter6/positionedMenus.xhtml"),
      new Page("Creating programmatic menu", "chapter6/programmaticMenu.xhtml"),
      new Page("Context menu with nested items", "chapter6/contextMenu.xhtml"),
      new Page("Context menu integration", "chapter6/contextMenuIntegration.xhtml"),
      new Page("Breadcrumb - contextual information about page hierarchy", "chapter6/breadcrumb.xhtml"),
      new Page("Slide Menu - menu in iPod style", "chapter6/slideMenu.xhtml"),
      new Page("Tiered Menu - submenus in nested overlays", "chapter6/tieredMenu.xhtml"),
      new Page("Mega Menu - multi-column menu", "chapter6/megaMenu.xhtml"),
      new Page("PanelMenu - hybrid of accordion and tree", "chapter6/panelMenu.xhtml"),
      new Page("MenuButton - multiple items in popup", "chapter6/menuButton.xhtml"),
      new Page("Accessing commands via Menubar", "chapter6/menubar.xhtml"),
      new Page("Displaying checkboxes in overlay menu", "chapter6/checkboxMenu.xhtml")));
    populateChapter("File Upload", List.of(
      new Page("Basic File Upload", "chapter7/fileUpload.xhtml"),
      new Page("Multiple File Upload", "chapter7/fileUploadMultiple.xhtml"),
      new Page("Filtering File Types for File Upload", "chapter7/fileUploadFiltering.xhtml"),
      new Page("Limiting File Size for File Upload", "chapter7/fileUploadSizeLimit.xhtml"),
      new Page("Client Side Callback for File Upload", "chapter7/fileUploadCallback.xhtml"),
      new Page("Uploading File with Drag & Drop", "chapter7/fileUploadDND.xhtml"),
      new Page("Multiple advanced file uploads in one form", "chapter7/multipleFileUploadInOneForm.xhtml"),
      new Page("Downloading Files", "chapter7/fileDownload.xhtml")));
    populateChapter("Charts", List.of(
      new Page("Making component Draggable", "chapter8/draggable.xhtml"),
      new Page("Restricting dragging by axis, grid and containment", "chapter8/advancedDraggable.xhtml"),
      new Page("Snapping to edges of near elements", "chapter8/snapping.xhtml"),
      new Page("Defining droppable targets", "chapter8/droppable.xhtml"),
      new Page("Restricting dropping by tolerance and acceptance", "chapter8/advancedDroppable.xhtml"),
      new Page("AJAX enhanced drag & drop", "chapter8/ajaxDragDrop.xhtml"),
      new Page("Integrating drag & drop with data iteration components", "chapter8/dragDropIntegration.xhtml")));
    populateChapter("Maps", List.of(
      new Page("Basic Map", "chapter9/map.xhtml"),
      new Page("Adding, Selecting and Dragging Markers in Maps", "chapter9/mapMarkers.xhtml"),
      new Page("Creating Rectangles, Circles, Polylines and Polygons in Maps", "chapter9/mapDrawings.xhtml"),
      new Page("Enabling InfoView and Street View on Maps", "chapter9/mapInfoView.xhtml"),
      new Page("Creating a line, area, bar and pie chart", "chapter9/chart.xhtml"),
      new Page("Creating combined chart", "chapter9/combinedChart.xhtml"),
      new Page("Updating live data in charts with polling", "chapter9/pollingChart.xhtml"),
      new Page("Interacting with charts via AJAX", "chapter9/chartInteraction.xhtml")));
    populateChapter("Client Side Validation", List.of(
      new Page("Basic validation", "chapter10/basicCsv.xhtml"),
      new Page("Instant validation", "chapter10/instantCsv.xhtml"),
      new Page("Bean validation", "chapter10/bvCsv.xhtml"),
      new Page("Extending CSV with JSF", "chapter10/extendJsfCsv.xhtml"),
      new Page("Extending CSV with Bean Validation", "chapter10/extendBvCsv.xhtml")));
    populateChapter("Layout Pitfalls", List.of(
      new  Page("Programmatic updating and scrolling with RequestContext", "chapter11/requestContext.xhtml"),
      new Page("Two ways to trigger JavaScript execution on server side", "chapter11/javaScriptExec.xhtml"),
      new Page("Adding AJAX callbacks parameters - validation within dialog", "chapter11/ajaxCallbacks.xhtml"),
      new Page("Opening external pages in dynamically generated dialog", "chapter11/dialogFramework.xhtml"),
      new Page("Polling - sending of periodical AJAX requests", "chapter11/polling.xhtml"),
      new Page("Blocking page pieces during long-running AJAX calls", "chapter11/blockUI.xhtml"),
      new Page("Controlling form submitting by DefaultCommand", "chapter11/defaultCommand.xhtml"),
      new Page("Clever focus management in forms", "chapter11/focusManagement.xhtml"),
      new Page("Layout pitfalls with menus and dialogs", "chapter11/layoutPitfalls.xhtml"),
      new Page("Targetable messages with severity levels", "chapter11/targetableMessages.xhtml"),
      new Page("Conditional coloring in DataTable", "chapter11/dataTableColoring.xhtml"),
      new Page("Sticking component when scrolling", "chapter11/sticking.xhtml"),
      new Page("Reducing page load time by content caching", "chapter11/caching.xhtml"),
      new Page("Possibilities for exception handling", "chapter11/exceptionHandling.xhtml")));
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

  private void populateChapter(String chapterTitle, List<Page> pages)
  {
    TreeNode<BookTreeNode> chapterNode =
      new DefaultTreeNode<>(new BookTreeNode(chapterTitle, null), root);
    pages.forEach(page ->
      new DefaultTreeNode<>(NODE_TYPE, new BookTreeNode(page.name(), page.view()), chapterNode));
  }
}
