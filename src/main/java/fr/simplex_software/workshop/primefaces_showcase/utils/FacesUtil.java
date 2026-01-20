package fr.simplex_software.workshop.primefaces_showcase.utils;

import jakarta.el.*;
import jakarta.faces.context.*;
import jakarta.faces.event.*;

public class FacesUtil
{

  public static MethodExpression createMethodExpression(String valueExpression, Class<?> expectedReturnType,
    Class<?>[] expectedParamTypes)
  {
    FacesContext fc = FacesContext.getCurrentInstance();
    ExpressionFactory factory = fc.getApplication().getExpressionFactory();

    return factory.createMethodExpression(fc.getELContext(), valueExpression, expectedReturnType, expectedParamTypes);
  }

  public static MethodExpressionActionListener createMethodActionListener(String valueExpression, Class<?> expectedReturnType,
    Class<?>[] expectedParamTypes)
  {
    return new MethodExpressionActionListener(createMethodExpression(valueExpression, expectedReturnType,
      expectedParamTypes));
  }
}
