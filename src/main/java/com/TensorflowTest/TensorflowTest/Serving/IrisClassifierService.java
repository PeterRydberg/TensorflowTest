package com.TensorflowTest.TensorflowTest.Serving;

import java.util.Map;

public interface IrisClassifierService {

    /**
     * Method to fetch a classification from the model
     * @param iris the data to classify
     * @return the predicted type
     */
    Iris.IrisType classify(Iris iris);

    /**
     * Method to fetch from the model the probabilities of all the types
     * @param iris the data to classify
     * @return A map relating the type with its predicted probabilities
     */
    Map<Iris.IrisType, Float> classificationProbabilities(Iris iris);
}
