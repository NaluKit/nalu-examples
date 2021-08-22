package de.gishmo.example.devk.client.constraint;

import com.github.nalukit.nalu.client.constraint.IsParameterConstraintRule;
import com.github.nalukit.nalu.client.constraint.annotation.NotEmpty;
import com.github.nalukit.nalu.client.constraint.annotation.ParameterConstraintRule;
import com.github.nalukit.nalu.client.constraint.annotation.Pattern;
import com.github.nalukit.nalu.client.constraint.annotation.WhiteListing;

@ParameterConstraintRule
@NotEmpty
@Pattern("^[0-9]{0,8}?$")
@WhiteListing({ "1",
                "2" })
public interface IdRule
    extends IsParameterConstraintRule {
}
