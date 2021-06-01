package com.clv.cipamig;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CipaAlert {
  private String alertName;
  private String owner;
  private String subscribers;
}
