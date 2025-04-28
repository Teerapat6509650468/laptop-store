document.getElementById('fetchCustomersBtn').addEventListener('click', fetchCustomers);
document.getElementById('addCustomerForm').addEventListener('submit', addCustomer);

function fetchCustomers() {
    fetch('/store/customers')
        .then(response => response.json())
        .then(customers => {
            const customerTableBody = document.getElementById('customerTableBody');
            customerTableBody.innerHTML = ''; // Clear the table body
            customers.forEach((customer, index) => {
                const row = document.createElement('tr');
                row.innerHTML = `
                    <td>${index + 1}</td>
                    <td>${customer.name}</td>
                    <td>${customer.email}</td>
                    <td>${customer.phone}</td>
                    <td>${customer.address}</td>
                `;
                customerTableBody.appendChild(row);
            });
        })
        .catch(error => console.error('Error fetching customers:', error));
}

function addCustomer(event) {
    event.preventDefault();
    const name = document.getElementById('customerName').value;
    const email = document.getElementById('customerEmail').value;
    const phone = document.getElementById('customerPhone').value;
    const address = document.getElementById('customerAddress').value;

    fetch('/store/customers/add', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ name, email, phone, address }),
    })
        .then(response => {
            if (response.ok) {
                alert('Customer added successfully!');
                document.getElementById('addCustomerForm').reset();
                fetchCustomers(); // Refresh the customer list
                const modal = bootstrap.Modal.getInstance(document.getElementById('addCustomerModal'));
                modal.hide();
            } else {
                alert('Failed to add customer.');
            }
        })
        .catch(error => console.error('Error adding customer:', error));
}