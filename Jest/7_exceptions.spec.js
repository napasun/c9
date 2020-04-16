function compileAndroidCode() {
    throw new ConfigError('you are using the wrong JDK');
}

test('compiling android goes as expected', () => {
    expect(compileAndroidCode).toThrow();
    //expect(compileAndroidCode).toThrow(ConfigError);

    //expect(compileAndroidCode).toThrow('you are using the wrong JDK');
    //expect(compileAndroidCode).toThrow(/JDK/)
})