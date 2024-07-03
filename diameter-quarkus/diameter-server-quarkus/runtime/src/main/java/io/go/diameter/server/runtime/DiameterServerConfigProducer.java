package io.go.diameter.server.runtime;

import io.go.diameter.DiameterServer;
import io.go.diameter.config.DiameterConfiguration;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import org.jdiameter.api.Configuration;

@ApplicationScoped
public class DiameterServerConfigProducer
{
	@Inject
	DiameterServerConfig config;

	@DiameterServer
	@Produces
	public Configuration getConfiguration()
	{
		return new DiameterConfiguration(config.getConfig());
	}
}
