/*
 * USE - UML based specification environment
 * Copyright (C) 1999-2004 Mark Richters, University of Bremen
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

// $Id$

package org.tzi.use.gui.views.diagrams;

import java.awt.Color;

import org.tzi.use.gui.util.PersistHelper;
import org.tzi.use.gui.xmlparser.LayoutTags;
import org.w3c.dom.Element;

/**
 * Contains Options for the class and object diagrams.
 * 
 * @version $ProjectVersion: 0.393 $
 * @author Fabian Gutsche
 */
public abstract class DiagramOptions {

    protected boolean fDoAutoLayout = false;
    protected boolean fShowRolenames = false;
    protected boolean fShowAssocNames = true;
    protected boolean fDoAntiAliasing = false;
    protected boolean fShowMutliplicities = false;
    protected boolean fShowAttributes = false;
    protected boolean fShowOperations = false;
    
    // color settings
    protected Color NODE_COLOR;
    protected Color NODE_SELECTED_COLOR;
    protected Color NODE_FRAME_COLOR;
    protected Color NODE_LABEL_COLOR;
    protected Color DIAMONDNODE_COLOR;
    protected Color DIAMONDNODE_FRAME_COLOR;
    protected Color EDGE_COLOR;
    protected Color EDGE_LABEL_COLOR;
    protected Color EDGE_SELECTED_COLOR;
    
    public abstract boolean isShowMutliplicities();
    public abstract void setShowMutliplicities( boolean showMutliplicities );
    
    public boolean isDoAutoLayout() {
        return fDoAutoLayout;
    }
    public void setDoAutoLayout( boolean doAutoLayout ) {
        fDoAutoLayout = doAutoLayout;
    }

    public boolean isShowAssocNames() {
        return fShowAssocNames;
    }
    public void setShowAssocNames( boolean showAssocNames ) {
        fShowAssocNames = showAssocNames;
    }

    public boolean isShowRolenames() {
        return fShowRolenames;
    }
    public void setShowRolenames( boolean showRolenames ) {
        fShowRolenames = showRolenames;
    }

    public boolean isDoAntiAliasing() {
        return fDoAntiAliasing;
    }
    public void setDoAntiAliasing( boolean doAntiAliasing ) {
        fDoAntiAliasing = doAntiAliasing;
    }
    
    public boolean isShowAttributes() {
        return fShowAttributes;
    }
    public void setShowAttributes( boolean showAttributes ) {
        fShowAttributes = showAttributes;
    }

    public boolean isShowOperations() {
        return fShowOperations;
    }
    public void setShowOperations( boolean showOperations ) {
        fShowOperations = showOperations;
    }
    
    
    
    
    public Color getDIAMONDNODE_COLOR() {
        return DIAMONDNODE_COLOR;
    }
    public Color getDIAMONDNODE_FRAME_COLOR() {
        return DIAMONDNODE_FRAME_COLOR;
    }
    public Color getEDGE_COLOR() {
        return EDGE_COLOR;
    }
    public Color getEDGE_LABEL_COLOR() {
        return EDGE_LABEL_COLOR;
    }
    public Color getEDGE_SELECTED_COLOR() {
        return EDGE_SELECTED_COLOR;
    }
    public Color getNODE_COLOR() {
        return NODE_COLOR;
    }
    public Color getNODE_FRAME_COLOR() {
        return NODE_FRAME_COLOR;
    }
    public Color getNODE_LABEL_COLOR() {
        return NODE_LABEL_COLOR;
    }
    public Color getNODE_SELECTED_COLOR() {
        return NODE_SELECTED_COLOR;
    }
    
    protected boolean fIsLoadingLayout = false;
    
	/**
	 * @return
	 */
	public boolean isLoadingLayout() {
		return fIsLoadingLayout;
	}
    
	public void setIsLoadingLayout(boolean isLoading) {
		fIsLoadingLayout = isLoading;
	}
	
	/**
	 * @param optionsElement
	 */
	public void saveOptions(Element parent) {
		// save diagram options
		PersistHelper.appendChild(parent, LayoutTags.AUTOLAYOUT, String.valueOf(isDoAutoLayout()));
		PersistHelper.appendChild(parent, LayoutTags.ANTIALIASING, String.valueOf(isDoAntiAliasing()));
		PersistHelper.appendChild(parent, LayoutTags.SHOWASSOCNAMES, String.valueOf(isShowAssocNames()));
		PersistHelper.appendChild(parent, LayoutTags.SHOWATTRIBUTES, String.valueOf(isShowAttributes()));        
		PersistHelper.appendChild(parent, LayoutTags.SHOWMULTIPLICITIES, String.valueOf(isShowMutliplicities()));
		PersistHelper.appendChild(parent, LayoutTags.SHOWOPERATIONS, String.valueOf(isShowOperations()));
		PersistHelper.appendChild(parent, LayoutTags.SHOWROLENAMES, String.valueOf(isShowRolenames()));
	}
	/**
	 * @param rootElement
	 */
	public void loadOptions(Element parent) {
		setDoAutoLayout(PersistHelper.getElementBooleanValue(parent, LayoutTags.AUTOLAYOUT));
		setDoAntiAliasing(PersistHelper.getElementBooleanValue(parent, LayoutTags.ANTIALIASING));
		setShowAssocNames(PersistHelper.getElementBooleanValue(parent, LayoutTags.SHOWASSOCNAMES));
		setShowAttributes(PersistHelper.getElementBooleanValue(parent, LayoutTags.SHOWATTRIBUTES));
		setShowMutliplicities(PersistHelper.getElementBooleanValue(parent, LayoutTags.SHOWMULTIPLICITIES));
		setShowOperations(PersistHelper.getElementBooleanValue(parent, LayoutTags.SHOWOPERATIONS));
		setShowRolenames(PersistHelper.getElementBooleanValue(parent, LayoutTags.SHOWROLENAMES));
	}
}
