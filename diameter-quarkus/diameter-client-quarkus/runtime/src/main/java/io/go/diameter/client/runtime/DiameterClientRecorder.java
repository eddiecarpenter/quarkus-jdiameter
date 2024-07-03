package io.go.diameter.client.runtime;

import io.go.diameter.config.DiameterConfig;
import io.go.diameter.config.DiameterConfiguration;
import io.quarkus.arc.SyntheticCreationalContext;
import io.quarkus.runtime.annotations.Recorder;
import io.smallrye.config.SmallRyeConfig;
import org.eclipse.microprofile.config.ConfigProvider;
import org.jdiameter.api.Configuration;

import java.util.function.Function;

@Recorder
public class DiameterClientRecorder
{
	public Function<SyntheticCreationalContext<Configuration>, Configuration> clientConfiguration(String clientName)
	{
		return context -> {
			SmallRyeConfig config = ConfigProvider.getConfig().unwrap(SmallRyeConfig.class);
			DiameterClientConfig client = config.getConfigMapping(DiameterClientConfig.class);

			DiameterConfig diameterConfig = client.getDiameterConfig(clientName);
			if (diameterConfig == null) {
				throw new IllegalArgumentException("No client configuration found for " + clientName);
			}
			return new DiameterConfiguration(diameterConfig);
		};
	}
}
