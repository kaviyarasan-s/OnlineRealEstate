$(document)
		.ready(
				function() {
					$('#name').blur(function() {
						var name = $('#name').val();
						if (name == null || name == '') {
							$("#namechkerr").text("*Username is required");
						} else if (name != null && name != '') {
							$("#namechkerr").text("");
						}
					});

					$('#name').keyup(function() {

						var name = $('#name').val();
						if (name == null || name == '') {
							$("#namechkerr").text("*Username is required");
						} else if (name != null && name != '') {
							if (name.match("^([a-zA-Z]+)$")) {
								$("#namechkerr").text('');
							} else {
								$("#namechkerr").text('*Enter letters only');
							}
						}

					});
					$('#email').blur(function() {
						var email = '';
						email = $('#email').val();
						if (email == null || email == '') {
							$("#emailchkerr").text("*Email is required");
						} else if (email != null && email != '') {
							$("#emailchkerr").text("");
						}

					});
					$('#email')
							.keyup(
									function() {
										var email = '';
										email = $('#email').val();
										if (email == null || email == '') {
											$("#emailchkerr").text(
													"*Email is required");
										} else if (email != null && email != '') {
											if (email
													.match("^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")) {
												$("#emailchkerr").text('');
											} else {
												$("#emailchkerr")
														.text(
																'*Enter valid email id');
											}

										}

									});
					$('#password').blur(function() {

						var password = $('#password').val();
						if (password == null || password == '') {
							$("#passwordchkerr").text("*Password is required");
						} else if (password != null && password != '') {
							$("#passwordchkerr").text("");
						}
					});

					$('#password')
							.keyup(
									function() {

										var password = $('#password').val();
										if (password == null || password == '') {
											$("#passwordchkerr").text(
													"*Password is required");
										} else if (password != null
												&& password != '') {
											if (password
													.match("^([a-zA-Z0-9$@]+)$")) {
												$("#passwordchkerr").text('');
											} else {
												$("#passwordchkerr")
														.text(
																'*Enter valid password.It should contains only number,upper or lower case letters,$,@');
											}

										}

									});
					$('#phonenumber').blur(
							function() {
								var phonenumber = $('#phonenumber').val();
								if (phonenumber == null || phonenumber == '') {
									$("#phonenumberchkerr").text(
											"*Mobilenumber is required");
								} else if (phonenumber != null
										&& phonenumber != '') {
									$("#phonenumberchkerr").text("");
								}
							});
					$('#phonenumber').keyup(
							function() {
								var phonenumber = $('#phonenumber').val();
								if (phonenumber == null || phonenumber == '') {
									$("#phonenumberchkerr").text(
											"*Mobilenumber is required");
								} else if (phonenumber != null
										&& phonenumber != '') {
									if (phonenumber.match("^([0-9]+)$")) {
										$("#phonenumberchkerr").text('');
									} else {
										$("#phonenumberchkerr").text(
												'Enter valid number');
									}
								}

							});

				})