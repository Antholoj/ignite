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

package org.apache.ignite.ml.selection.scoring.metric.classification;

import org.apache.ignite.ml.selection.scoring.TestLabelPairCursor;
import org.apache.ignite.ml.selection.scoring.cursor.LabelPairCursor;
import org.apache.ignite.ml.selection.scoring.metric.Metric;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Tests for {@link Accuracy}.
 */
public class AccuracyTest {
    /** */
    @Test
    public void testScore() {
        Metric<Integer> scoreCalculator = new Accuracy<>();

        LabelPairCursor<Integer> cursor = new TestLabelPairCursor<>(
            Arrays.asList(1, 1, 1, 1),
            Arrays.asList(1, 1, 0, 1)
        );

        double score = scoreCalculator.score(cursor.iterator());

        assertEquals(0.75, score, 1e-12);
    }
}
