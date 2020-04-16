/*
 * Copyright (c) 2020 Proton Technologies AG
 * 
 * This file is part of ProtonMail.
 * 
 * ProtonMail is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * ProtonMail is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with ProtonMail. If not, see https://www.gnu.org/licenses/.
 */
package ch.protonmail.android.api.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import ch.protonmail.android.api.utils.Fields;
import ch.protonmail.android.core.Constants;

/**
 * Created by dkadrikj on 7/6/16.
 */
public class AvailablePlansResponse extends ResponseBody implements Serializable {
    @SerializedName(Fields.Subscription.PLANS)
    private List<Plan> plans;

    public AvailablePlansResponse(List<Plan> plans) {
        this.plans = plans;
    }

    public List<Plan> getPlans() {
        return plans;
    }

    public String getCurrency() {
        if (plans != null && plans.size() > 0) {
            return plans.get(0).getCurrency();
        }
        return null;
    }

    public int getCycle() {
        if (plans != null && plans.size() > 0) {
            return plans.get(0).getCycle();
        }
        return 0;
    }

    public Plan getPlanByPlanType(Constants.PlanType planType) {
        Plan wantedPlan = null;
        for (Plan plan : plans) {
            if (Constants.PlanType.Companion.fromString(plan.getName()) == planType) {
                wantedPlan = plan;
                break;
            }
        }
        return wantedPlan;
    }
}
