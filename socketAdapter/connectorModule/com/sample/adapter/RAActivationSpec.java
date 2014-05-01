package com.sample.adapter;

import javax.resource.ResourceException;
import javax.resource.spi.InvalidPropertyException;
import javax.resource.spi.ResourceAdapter;

public class RAActivationSpec implements javax.resource.spi.ActivationSpec {

	private String _factory;
	private String _location;
	private ResourceAdapter _adapter;

	public String getFactory() {
		return _factory;
	}

	public void validate() throws InvalidPropertyException {
	}

	public ResourceAdapter getResourceAdapter() {
		return null;
	}

	public void setResourceAdapter(ResourceAdapter arg0)
			throws ResourceException {
	}

	public String get_factory() {
		return _factory;
	}

	public void set_factory(String _factory) {
		this._factory = _factory;
	}

	public String get_location() {
		return _location;
	}

	public void set_location(String _location) {
		this._location = _location;
	}

	public ResourceAdapter get_adapter() {
		return _adapter;
	}

	public void set_adapter(ResourceAdapter _adapter) {
		this._adapter = _adapter;
	}

}
