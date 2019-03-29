$(document).ready(function() {
	$('#landprice').blur(function() {
		var price = $('#landprice').val();
		if (price.match("^([0-9]+)$")) {
			$('#pricechkerr').text('');
		} else {
			$('#pricechkerr').text('*Enter valid price');
		}

	});

	$('#price').blur(function() {
		var price = $('#price').val();
		if (price != null && price != '') {
			if (price.match("^([0-9]+)$")) {
				$('#pricechkerr').text('');
			} else {
				$('#pricechkerr').text('*Enter valid price');
			}
		} else {
			$('#pricechkerr').text('*Enter price');
		}

	});

	$('#buildingname').blur(function() {
		var buildingname = $('#buildingname').val();
		if (buildingname != null && buildingname != '') {
			if (buildingname.match("^([a-zA-Z]+)$")) {
				$('#buildingnamechkerr').text('');
			} else {
				$('#buildingnamechkerr').text('*Enter valid building name');
			}
		} else {
			$('#buildingnamechkerr').text('*Enter building name');
		}

	});

	$('#landsize').blur(function() {
		var landsize = $('#landsize').val();
		if (landsize != null && buildingname != '') {
			if (landsize.match("^([0-9]+)$")) {
				$('#landsizechkerr').text('');
			} else {
				$('#landsizechkerr').text('*Enter valid land size');
			}
		} else {
			$('#landsizechkerr').text('*Enter land size');
		}

	});
	$('#discount').blur(function() {
		var discount = $('#discount').val();

		if (discount.match("^([0-9]+)$")) {
			$('#discountchkerr').text('');
		} else {
			$('#discountchkerr').text('*Enter discount');
		}

	});
	$('#status').blur(function() {
		var status = $('#status').val();

		if (status.match("^([a-zA-Z]+)$")) {
			$('#statuschkerr').text('');
		} else {
			$('#statuschkerr').text('*Select status');
		}

	});
//	$("#landetails").submit(function() {
		$('#propertytype').blur(function() {
			var propertytype = $('#propertytype').val();

			if (propertytype != 0) {
				$('#propertytypechkerr').text('');
			} else {
				$('#propertytypechkerr').text('*Select propertytype');
			}

		});
		$('#bhk').blur(function() {
			var bhk = $('#bhk').val();

			if (bhk != 0) {
				$('#bhkchkerr').text('');
			} else {
				$('#bhkchkerr').text('*Select bhk');
			}

		});
		$('#city').blur(function() {
			var city = $('#city').val();

			if (city != 0) {
				$('#citychkerr').text('');
			} else {
				$('#citychkerr').text('*Select city');
			}

		});
		$('#locality').blur(function() {
			var locality = $('#locality').val();

			if (locality != 0) {
				$('#localitychkerr').text('');
			} else {
				$('#localitychkerr').text('*Select locality');
			}

		});
		$('#transactiontype').blur(function() {
			var transactiontype = $('#transactiontype').val();

			if (transactiontype != 0) {
				$('#transactiontypechkerr').text('');
			} else {
				$('#transactiontypechkerr').text('*Select transactiontype');
			}

		});
		$('#purchasetype').blur(function() {
			var purchasetype = $('#purchasetype').val();

			if (purchasetype != 0) {
				$('#purchasetypechkerr').text('');
			} else {
				$('#purchasetypechkerr').text('*Select purchasetype');
			}

		});
			//check condition
			
//			var landsize = $('#landsize').val();
//			if (landsize != null && buildingname != '') {
//				if (landsize.match("^([0-9]+)$")) {
//					$('#landsizechkerr').text('');
//				} else {
//					$('#landsizechkerr').text('*Enter valid land size');
//				}
//			} else {
//				$('#landsizechkerr').text('*Enter land size');
//			}
//			
//			var price = $('#price').val();
//			if (price != null && price != '') {
//				if (price.match("^([0-9]+)$")) {
//					$('#pricechkerr').text('');
//				} else {
//					$('#pricechkerr').text('*Enter valid price');
//				}
//			} else {
//				$('#pricechkerr').text('*Enter price');
//			}
//			
//			var buildingname = $('#buildingname').val();
//			if (buildingname != null && buildingname != '') {
//				if (buildingname.match("^([a-zA-Z]+)$")) {
//					$('#buildingnamechkerr').text('');
//				} else {
//					$('#buildingnamechkerr').text('*Enter valid building name');
//				}
//			} else {
//				$('#buildingnamechkerr').text('*Enter building name');
//			}
//			
//			var discount = $('#discount').val();
//
//			if (discount.match("^([0-9]+)$")) {
//				$('#discountchkerr').text('');
//			} else {
//				$('#discountchkerr').text('*Enter discount');
//			}
//	});

});