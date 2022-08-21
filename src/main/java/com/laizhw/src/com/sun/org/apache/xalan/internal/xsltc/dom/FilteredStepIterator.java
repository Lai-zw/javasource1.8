/*
 * Copyright (c) 2007, 2021, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sun.org.apache.xalan.internal.xsltc.dom;

import com.sun.org.apache.xml.internal.dtm.DTMAxisIterator;

/**
 * Extends a StepIterator by adding the ability to filter nodes. It
 * uses filters similar to those of a FilterIterator.
 * @author Jacek Ambroziak
 * @author Santiago Pericas-Geertsen
 * @author Morten Jorgensen
 */
public final class FilteredStepIterator extends StepIterator {

    private Filter _filter;

    public FilteredStepIterator(DTMAxisIterator source,
                                DTMAxisIterator iterator,
                                Filter filter) {
        super(source, iterator);
        _filter = filter;
    }

    public int next() {
        int node;
        while ((node = super.next()) != END) {
            if (_filter.test(node)) {
                return returnNode(node);
            }
        }
        return node;
    }

}