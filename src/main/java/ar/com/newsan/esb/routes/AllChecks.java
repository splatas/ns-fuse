package ar.com.newsan.esb.routes;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({Default.class, OptionalChecks.class})
public interface AllChecks {

}
