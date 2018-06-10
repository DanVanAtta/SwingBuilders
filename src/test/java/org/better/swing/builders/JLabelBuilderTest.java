package org.better.swing.builders;

import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.swing.JComponent;
import javax.swing.JLabel;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

public class JLabelBuilderTest {

  @Test
  public void text() {
    final String value = "some text";
    final JLabel label = JLabelBuilder.builder()
        .text(value)
        .build();
    MatcherAssert.assertThat(label.getText(), is(value));
  }

  @Test
  public void leftAlign() {
    final JLabel label = JLabelBuilder.builder()
        .text("value")
        .leftAlign()
        .build();
    MatcherAssert.assertThat(label.getAlignmentX(), is(JComponent.LEFT_ALIGNMENT));
  }

  @Test
  public void iconTextGap() {
    final int value = 42;
    final JLabel label = JLabelBuilder.builder()
        .text("value")
        .iconTextGap(value)
        .build();
    MatcherAssert.assertThat(label.getIconTextGap(), is(value));
  }

  @Test
  public void textOrIconIsRequired() {
    assertThrows(IllegalStateException.class, JLabelBuilder.builder()::build);
  }

  @Test
  public void maxSize() {
    final int maxWidth = 300;
    final int maxHeight = 500;
    final JLabel label = JLabelBuilder.builder()
        .text("testing")
        .maximumSize(maxWidth, maxHeight)
        .build();

    MatcherAssert.assertThat(label.getMaximumSize().width, is(maxWidth));
    MatcherAssert.assertThat(label.getMaximumSize().height, is(maxHeight));
  }
}
