package org.mossab.elationhealth;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mossab.elationhealth.lab.SearchResult;

import java.io.FileNotFoundException;

/**
 * Created by mossab on 9/6/17.
 *
 * @author: mossab
 */
public class ApplicationTest {
    @Before
    public void loadInitial() throws FileNotFoundException {
        Application.readInitialResults();
    }

    public void loadNewResults() throws FileNotFoundException {
        if (Application.labResultList.getResults().size() == 240000) {
            Application.readUpdatedResults();
        }
    }

    @Test
    public void testResultId126() {
        SearchResult searchResult = Application.labResultList.findRecents(126L);
        Assert.assertNotNull(searchResult);
        Assert.assertNotNull(searchResult.getResultId());
        Assert.assertEquals(searchResult.getResultId().longValue(), 126L);

        Assert.assertNotNull(searchResult.getLastThreeValues());
        Assert.assertEquals(searchResult.getLastThreeValues().size(), 3);

        Assert.assertEquals(searchResult.getLastThreeValues().get(0).getResultId().longValue(), 200L);
        Assert.assertEquals(searchResult.getLastThreeValues().get(1).getResultId().longValue(), 131L);
        Assert.assertEquals(searchResult.getLastThreeValues().get(2).getResultId().longValue(), 48L);
    }

    @Test
    public void testResultId10540() {
        SearchResult searchResult = Application.labResultList.findRecents(10540L);
        Assert.assertNotNull(searchResult);
        Assert.assertNotNull(searchResult.getResultId());
        Assert.assertEquals(searchResult.getResultId().longValue(), 10540L);

        Assert.assertNotNull(searchResult.getLastThreeValues());
        Assert.assertEquals(searchResult.getLastThreeValues().size(), 3);

        Assert.assertEquals(searchResult.getLastThreeValues().get(0).getResultId().longValue(), 10708L);
        Assert.assertEquals(searchResult.getLastThreeValues().get(1).getResultId().longValue(), 10645L);
        Assert.assertEquals(searchResult.getLastThreeValues().get(2).getResultId().longValue(), 10663L);
    }

    @Test
    public void testResultId1245() {
        SearchResult searchResult = Application.labResultList.findRecents(1245L);
        Assert.assertNotNull(searchResult);
        Assert.assertNotNull(searchResult.getResultId());
        Assert.assertEquals(searchResult.getResultId().longValue(), 1245L);

        Assert.assertNotNull(searchResult.getLastThreeValues());
        Assert.assertEquals(searchResult.getLastThreeValues().size(), 3);

        Assert.assertEquals(searchResult.getLastThreeValues().get(0).getResultId().longValue(), 1446L);
        Assert.assertEquals(searchResult.getLastThreeValues().get(1).getResultId().longValue(), 1300L);
        Assert.assertEquals(searchResult.getLastThreeValues().get(2).getResultId().longValue(), 1368L);
    }

    @Test
    public void testResultId1245Updated() throws FileNotFoundException {
        loadNewResults();

        SearchResult searchResult = Application.labResultList.findRecents(1245L);
        Assert.assertNotNull(searchResult);
        Assert.assertNotNull(searchResult.getResultId());
        Assert.assertEquals(searchResult.getResultId().longValue(), 1245L);

        Assert.assertNotNull(searchResult.getLastThreeValues());
        Assert.assertEquals(searchResult.getLastThreeValues().size(), 3);

        Assert.assertEquals(searchResult.getLastThreeValues().get(0).getResultId().longValue(), 240018L);
        Assert.assertEquals(searchResult.getLastThreeValues().get(1).getResultId().longValue(), 1446L);
        Assert.assertEquals(searchResult.getLastThreeValues().get(2).getResultId().longValue(), 1300L);
    }

    @Test
    public void testResultId119Updated() throws FileNotFoundException {
        loadNewResults();

        SearchResult searchResult = Application.labResultList.findRecents(119L);
        Assert.assertNotNull(searchResult);
        Assert.assertNotNull(searchResult.getResultId());
        Assert.assertEquals(searchResult.getResultId().longValue(), 119L);

        Assert.assertNotNull(searchResult.getLastThreeValues());
        Assert.assertEquals(searchResult.getLastThreeValues().size(), 3);

        Assert.assertEquals(searchResult.getLastThreeValues().get(0).getResultId().longValue(), 240002L);
        Assert.assertEquals(searchResult.getLastThreeValues().get(1).getResultId().longValue(), 176L);
        Assert.assertEquals(searchResult.getLastThreeValues().get(2).getResultId().longValue(), 240005L);
    }
}