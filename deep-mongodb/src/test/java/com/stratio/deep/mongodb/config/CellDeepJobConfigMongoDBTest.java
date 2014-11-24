package com.stratio.deep.mongodb.config;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import com.stratio.deep.testutils.UnitTest;
import org.testng.annotations.Test;

import com.stratio.deep.commons.entity.Cells;

/**
 * Created by rcrespo on 16/07/14.
 */
@Test
@UnitTest
public class CellDeepJobConfigMongoDBTest {

    @Test
    public void createTest() {

        MongoDeepJobConfig<Cells> cellDeepJobConfigMongoDB = new MongoDeepJobConfig(Cells.class);

        assertNotNull(cellDeepJobConfigMongoDB);

        assertEquals(cellDeepJobConfigMongoDB.getEntityClass(), Cells.class);

    }

}
