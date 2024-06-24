package vn.edu.ptithcm.studentmangementstudio.domain.entity;


public record Result<DataType, ErrorType>(DataType data, ErrorType error) {

    public static <DataType, ErrorType> Result<DataType, ErrorType> success(DataType data) {
        return new Result<>(data, null);
    }

    public static <DataType, ErrorType> Result<DataType, ErrorType> error(ErrorType error) {
        return new Result<>(null, error);
    }

    public boolean isSuccess() {
        return data != null;
    }

    public boolean isError() {
        return error != null;
    }

    public String getErrorMessage() {
        return error.toString();
    }
}
