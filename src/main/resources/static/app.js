var app = angular.module('insuranceApp', []);

app.controller('MainController', function($scope, $http) {
    $scope.currentTab = 'clients'; // Default tab
    $scope.clients = [];
    $scope.policies = [];
    $scope.claims = [];
    $scope.currentClient = {};
    $scope.currentPolicy = {};
    $scope.currentClaim = {};
    $scope.isClientFormVisible = false;
    $scope.isPolicyFormVisible = false;
    $scope.isClaimFormVisible = false;
    $scope.clientFormTitle = 'Add Client';
    $scope.policyFormTitle = 'Add Policy';
    $scope.claimFormTitle = 'Add Claim';

    // --- Client Functions ---

    $scope.loadClients = function() {
        $http.get('/insuranceAPI/displayAllClient')
            .then(function(response) {
                $scope.clients = response.data.data;
            }, function(error) {
                console.error('Error loading clients:', error);
            });
    };

    $scope.showAddClientModal = function() {
        $scope.currentClient = {};
        $scope.clientFormTitle = 'Add Client';
        $scope.isClientFormVisible = true;
    };

    $scope.editClient = function(client) {
        $scope.currentClient = angular.copy(client);
        $scope.clientFormTitle = 'Edit Client';
        $scope.isClientFormVisible = true;
    };

    $scope.saveClient = function() {
        if ($scope.clientFormTitle === 'Add Client') {
            var policyId = $scope.currentClient.policyId;
            if (!policyId) {
                alert("Policy ID is required for new clients.");
                return;
            }
            $http.post('/insuranceAPI/saveClient/' + policyId, $scope.currentClient)
                .then(function(response) {
                    $scope.loadClients();
                    $scope.cancelClientForm();
                }, function(error) {
                    console.error('Error saving client:', error);
                });
        } else {
            $http.put('/insuranceAPI/updateClient/' + $scope.currentClient.clientId, $scope.currentClient)
                .then(function(response) {
                    $scope.loadClients();
                    $scope.cancelClientForm();
                }, function(error) {
                    console.error('Error updating client:', error);
                });
        }
    };

    $scope.deleteClient = function(clientId) {
        if (confirm('Are you sure you want to delete this client?')) {
            $http.delete('/insuranceAPI/deleteClient/' + clientId)
                .then(function(response) {
                    $scope.loadClients();
                }, function(error) {
                    console.error('Error deleting client:', error);
                });
        }
    };

    $scope.cancelClientForm = function() {
        $scope.isClientFormVisible = false;
        $scope.currentClient = {};
    };

    // --- Policy Functions ---

    $scope.loadPolicies = function() {
        $http.get('/insuranceAPI/displayAllPolicy')
            .then(function(response) {
                $scope.policies = response.data.data;
            }, function(error) {
                console.error('Error loading policies:', error);
            });
    };

    $scope.showAddPolicyModal = function() {
        $scope.currentPolicy = {};
        $scope.policyFormTitle = 'Add Policy';
        $scope.isPolicyFormVisible = true;
    };

    $scope.editPolicy = function(policy) {
        $scope.currentPolicy = angular.copy(policy);
        $scope.policyFormTitle = 'Edit Policy';
        $scope.isPolicyFormVisible = true;
    };

    $scope.savePolicy = function() {
        if ($scope.policyFormTitle === 'Add Policy') {
            $http.post('/insuranceAPI/saveInsurancePolicy', $scope.currentPolicy)
                .then(function(response) {
                    $scope.loadPolicies();
                    $scope.cancelPolicyForm();
                }, function(error) {
                    console.error('Error saving policy:', error);
                });
        } else {
            $http.put('/insuranceAPI/updateInsurancePolicy/' + $scope.currentPolicy.insurancePolicyId, $scope.currentPolicy)
                .then(function(response) {
                    $scope.loadPolicies();
                    $scope.cancelPolicyForm();
                }, function(error) {
                    console.error('Error updating policy:', error);
                });
        }
    };

    $scope.deletePolicy = function(policyId) {
        if (confirm('Are you sure you want to delete this policy?')) {
            $http.delete('/insuranceAPI/deleteInsurancePolicy/' + policyId)
                .then(function(response) {
                    $scope.loadPolicies();
                }, function(error) {
                    console.error('Error deleting policy:', error);
                });
        }
    };

    $scope.cancelPolicyForm = function() {
        $scope.isPolicyFormVisible = false;
        $scope.currentPolicy = {};
    };

    // --- Claim Functions ---

    $scope.loadClaims = function() {
        $http.get('/insuranceAPI/displayAllClaim')
            .then(function(response) {
                $scope.claims = response.data.data;
            }, function(error) {
                console.error('Error loading claims:', error);
            });
    };

    $scope.showAddClaimModal = function() {
        $scope.currentClaim = {};
        $scope.claimFormTitle = 'Add Claim';
        $scope.isClaimFormVisible = true;
    };

    $scope.editClaim = function(claim) {
        $scope.currentClaim = angular.copy(claim);
        $scope.claimFormTitle = 'Edit Claim';
        $scope.isClaimFormVisible = true;
    };

    $scope.saveClaim = function() {
        if ($scope.claimFormTitle === 'Add Claim') {
            var policyId = $scope.currentClaim.policyId;
            if (!policyId) {
                alert("Policy ID is required for new claims.");
                return;
            }
            $http.post('/insuranceAPI/saveClaim/' + policyId, $scope.currentClaim)
                .then(function(response) {
                    $scope.loadClaims();
                    $scope.cancelClaimForm();
                }, function(error) {
                    console.error('Error saving claim:', error);
                });
        } else {
            $http.put('/insuranceAPI/updateClaim/' + $scope.currentClaim.claimId, $scope.currentClaim)
                .then(function(response) {
                    $scope.loadClaims();
                    $scope.cancelClaimForm();
                }, function(error) {
                    console.error('Error updating claim:', error);
                });
        }
    };

    $scope.deleteClaim = function(claimId) {
        if (confirm('Are you sure you want to delete this claim?')) {
            $http.delete('/insuranceAPI/deleteClaim/' + claimId)
                .then(function(response) {
                    $scope.loadClaims();
                }, function(error) {
                    console.error('Error deleting claim:', error);
                });
        }
    };

    $scope.cancelClaimForm = function() {
        $scope.isClaimFormVisible = false;
        $scope.currentClaim = {};
    };

    // Initial Load
    $scope.loadClients();
    $scope.loadPolicies();
    $scope.loadClaims();
});