from src.common.exceptions import InvalidInputException
from src.common.constants import DEFAULT_CURRENCY


class UserService:
    def __init__(self):
        # In-memory storage for simplicity
        self.users = {}

    def create_user(self, user_id, name, monthly_budget, currency=None):
        """
        Creates a new user with a monthly budget.
        """

        if user_id in self.users:
            raise InvalidInputException("User already exists")

        self._validate_budget(monthly_budget)

        if not currency:
            currency = DEFAULT_CURRENCY

        self.users[user_id] = {
            "user_id": user_id,
            "name": name,
            "monthly_budget": monthly_budget,
            "currency": currency
        }

        return self.users[user_id]

    def update_budget(self, user_id, new_budget):
        """
        Updates monthly budget for an existing user.
        """

        self._validate_user_exists(user_id)
        self._validate_budget(new_budget)

        self.users[user_id]["monthly_budget"] = new_budget
        return self.users[user_id]

    def reset_user(self, user_id):
        """
        Deletes all user data.
        """

        self._validate_user_exists(user_id)
        del self.users[user_id]
        return True

    def get_user(self, user_id):
        """
        Returns user details.
        """

        self._validate_user_exists(user_id)
        return self.users[user_id]

    # -------- Private helper methods --------

    def _validate_budget(self, budget):
        if budget <= 0:
            raise InvalidInputException("Monthly budget must be greater than zero")

    def _validate_user_exists(self, user_id):
        if user_id not in self.users:
            raise InvalidInputException("User does not exist")