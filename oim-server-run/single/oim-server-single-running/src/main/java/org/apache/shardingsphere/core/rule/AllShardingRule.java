package org.apache.shardingsphere.core.rule;

import java.util.Collection;

import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;

import java.util.Optional;
import com.google.common.base.Strings;

import lombok.Getter;

@Getter
public class AllShardingRule extends ShardingRule {

	public AllShardingRule(ShardingRuleConfiguration shardingRuleConfig, Collection<String> dataSourceNames) {
		super(shardingRuleConfig, dataSourceNames);
	}

	/**
	 * Find table rule.
	 *
	 * @param logicTableName logic table name
	 * @return table rule
	 */

	public Optional<TableRule> findTableRule(final String logicTableName) {
		for (TableRule each : this.getTableRules()) {
			if (each.getLogicTable().equalsIgnoreCase(logicTableName)) {
				return Optional.of(each);
			}
		}
		ShardingDataSourceNames names = this.getShardingDataSourceNames();
		return Optional.of(new TableRule(names.getDataSourceNames(), logicTableName));
	}

	/**
	 * Get table rule.
	 *
	 * @param logicTableName logic table name
	 * @return table rule
	 */
	public TableRule getTableRule(final String logicTableName) {
		Optional<TableRule> tableRule = findTableRule(logicTableName);
		if (tableRule.isPresent()) {
			return tableRule.get();
		}
		ShardingDataSourceNames names = this.getShardingDataSourceNames();
		if (!Strings.isNullOrEmpty(names.getDefaultDataSourceName())) {
			return new TableRule(names.getDefaultDataSourceName(), logicTableName);
		}
		return new TableRule(names.getDataSourceNames(), logicTableName);
	}
}
